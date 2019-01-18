package ao.ai.evo.genome;

import ao.ai.evo.chromosome.Chromosome;
import ao.ai.evo.primordial_soup.PrimordialSoup;


/**
 *
 */
public class UniGenome extends AbstractGenome<UniGenome>
{
    //--------------------------------------------------------------------
    private Chromosome solver;


    //--------------------------------------------------------------------
    public UniGenome(Chromosome problemSolver)
    {
        solver  = problemSolver;
    }


    //--------------------------------------------------------------------
    protected void doEvaluate()
    {
        solver.execute();
    }


    //--------------------------------------------------------------------
    public UniGenome replicate()
    {
        return new UniGenome( solver.replicate() );
    }

    public UniGenome recombine(UniGenome with)
    {
        return new UniGenome( solver.recombine(with.solver) );
    }

    public UniGenome microMutate(PrimordialSoup soup)
    {
        return new UniGenome( solver.microMutate(soup) );
    }

    public UniGenome macroMutate(PrimordialSoup soup)
    {
        return new UniGenome( solver.macroMutate(soup) );
    }

    public int size()
    {
        return solver.size();
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return solver.toString();
    }
}
