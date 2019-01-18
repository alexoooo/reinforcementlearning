package ao.ai.evo.deme;

import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.ai.evo.genome.Genome;
import ao.ai.evo.fitness.Feedback;

/**
 * A Deme occupies a Niche.
 */
public interface Deme
{
    //--------------------------------------------------------------------
    // injection by name.
    public static final String POP_SIZE_ID     = "deme.size";
    public static final String MACRO_WEIGHT_ID = "macro.weight";
    public static final String MICRO_WEIGHT_ID = "micro.weight";
    public static final String CROSS_WEIGHT_ID = "cross.weight";


    //--------------------------------------------------------------------
    public Genome nextIndividual(PrimordialSoup soup);


    /**
     * Reports that the given genome did
     *  not take any desired action upon request.
     * Presumably this will get rid of it or give
     *  it some penalty.
     *
     * @param genome ...
     */
    public void didNotAct(Genome genome);

    public void actionPerformed(Genome genome);
    

    public void select(
            Feedback pressure,
            PrimordialSoup soup);
}

