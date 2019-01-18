package ao.ai.evo.genome;

import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.ai.evo.chromosome.Chromosome;

import java.util.LinkedList;

/**
 *
 */
public class NicheGenome extends AbstractGenome<NicheGenome>
{
    //--------------------------------------------------------------------
    private final Chromosome output;
    private final Chromosome condition;

    private final LinkedList<Object> inputBuffer;


    //--------------------------------------------------------------------
    public NicheGenome(Chromosome niche, Chromosome action)
    {
        output      = action;
        condition   = niche;
        inputBuffer = new LinkedList<Object>();
    }


    //--------------------------------------------------------------------
    public void evaluateCondition()
    {
        condition.execute();
    }
    
    protected void doEvaluate()
    {
        output.execute();
    }


    //--------------------------------------------------------------------
    public NicheGenome replicate()
    {
        return new NicheGenome(condition.replicate(),
                               output.replicate());
    }


    //--------------------------------------------------------------------
    public NicheGenome recombine(NicheGenome with)
    {
        return null;
    }

    public NicheGenome recombineCondition(NicheGenome with)
    {
        return null;
    }


    //--------------------------------------------------------------------
    public NicheGenome microMutate(PrimordialSoup soup)
    {
        return null;
    }

    public NicheGenome microMutateCondition(PrimordialSoup soup)
    {
        return null;
    }


    //--------------------------------------------------------------------
    public NicheGenome macroMutate(PrimordialSoup soup)
    {
        return null;
    }

    public NicheGenome macroMutateCondition(PrimordialSoup soup)
    {
        return null;
    }

    public int size()
    {
        return 0;
    }
}
