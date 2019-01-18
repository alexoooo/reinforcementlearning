package ao.ai.evo.deme;

import ao.ai.evo.chromosome.Chromosome;
import ao.ai.evo.fitness.Feedback;
import ao.ai.evo.genome.Genome;
import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.util.rand.Rand;
import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 *
 */
public class MultiDeme implements Deme
{
    //--------------------------------------------------------------------
    private AbstractDeme[][] topology;
    private Deme             active = null;


    //--------------------------------------------------------------------
    @Inject
    public MultiDeme(
            @Named(POP_SIZE_ID) int size,
            @Named(MACRO_WEIGHT_ID) int injectedMacroWeight,
            @Named(MICRO_WEIGHT_ID) int injectedMicroWeight,
            @Named(CROSS_WEIGHT_ID) int injectedCrossWeight,
            Chromosome.Factory injectedChromosomeFactory)
    {
        int popSize = (int) Math.sqrt(size) * 2;
        int topRows = (int) Math.ceil(  Math.sqrt(popSize/4) );
        int topCols = (int) Math.floor( Math.sqrt(popSize/4) );

        topology = new AbstractDeme[topRows][topCols];
        for (int row = 0; row < topRows; row++)
        {
            for (int col = 0; col < topCols; col++)
            {
                AbstractDeme deme = new ConsistentRewardDeme();
                deme.injectPopulationSize( popSize );
                deme.injectMacroWeight( injectedMacroWeight );
                deme.injectMicroWeight( injectedMicroWeight );
                deme.injectCrossWeight( injectedCrossWeight );
                deme.injectChromosomeFactory( injectedChromosomeFactory );

                topology[row][col] = deme;
            }
        }
    }


    //--------------------------------------------------------------------
    public Genome nextIndividual(PrimordialSoup soup)
    {
        if (active == null)
        {
            active = randomIsland();
        }
        return active.nextIndividual(soup);
    }

    public void didNotAct(Genome genome)
    {
        if (active == null) return;
        active.didNotAct( genome );
        active = null;
    }

    public void actionPerformed(Genome genome)
    {
        if (active == null) return;
        active.actionPerformed( genome );
    }

    public void select(Feedback pressure, PrimordialSoup soup)
    {
        if (active == null) return;

        active.select(pressure, soup);
        active = null;

        if (Rand.nextDouble() < 0.001)
        {
            migration();
        }
    }

    //--------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    private void migration()
    {
        int srcRow = Rand.nextInt(topology.length);
        int srcCol = Rand.nextInt(topology[srcRow].length);

        int dstRow, dstCol;
        switch (Rand.nextInt(4))
        {
            case 0:
                dstRow = srcRow;
                dstCol = (srcCol + 1) % topology[srcRow].length;
                break;
            case 1:
                dstRow = mod(srcRow - 1, topology.length);
                dstCol = srcCol;
                break;
            case 2:
                dstRow = srcRow;
                dstCol = mod(srcCol - 1, topology[srcRow].length);
                break;
//            case 3:
            default:
                dstRow = (srcRow + 1) % topology.length;
                dstCol = srcCol;
                break;
        }

        AbstractDeme srcDeme = topology[srcRow][srcCol];
        AbstractDeme dstDeme = topology[dstRow][dstCol];
        Genome src     = srcDeme.highQualityRandomIndividual();
        Genome dstGood = dstDeme.highQualityRandomIndividual();
        Genome dstBad  = dstDeme.lowQualityRandomIndividual();
        if (src != null && dstGood != null && dstBad != null)
        {
            dstDeme.replace( dstBad, (Genome) src.recombine(dstGood) );
        }
    }
    private int mod(int a, int mod)
    {
        int m = a % mod;
        return (m >= 0) ? m : mod + m;
    }

    //--------------------------------------------------------------------
    private AbstractDeme randomIsland()
    {
        return Rand.fromArray( Rand.fromArray(topology) );
    }
}
