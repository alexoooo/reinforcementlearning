package ao.ai.evo.genome;

import ao.ai.evo.fitness.Fitness;

/**
 *
 */
public abstract class AbstractGenome<T extends AbstractGenome>
        implements Genome<T>
{
    //--------------------------------------------------------------------
    private Fitness fitness = new Fitness();
    private int     evaluationCount;


    //--------------------------------------------------------------------
    public int fitnessConfidence()
    {
        return fitness.confidence();
    }

    public int evaluationCount()
    {
        return evaluationCount;
    }


    //--------------------------------------------------------------------
    public void cumulate(Fitness delta)
    {
        fitness = fitness.cumulate( delta );
    }
    public void reduceFitness()
    {
        fitness = fitness.reduce();
    }


    //--------------------------------------------------------------------
    public void evaluate()
    {
        evaluationCount++;
        doEvaluate();
    }
    protected abstract void doEvaluate();
    

    //--------------------------------------------------------------------
    public int compareTo(T o)
    {
        return fitness.compareTo( o.fitness );
    }
}
