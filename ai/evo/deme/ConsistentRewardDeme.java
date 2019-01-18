package ao.ai.evo.deme;

import ao.ai.evo.genome.Genome;
import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.ai.evo.fitness.Feedback;
import ao.util.rand.Rand;

import java.util.List;
import java.util.HashSet;


/**
 *
 */
public class ConsistentRewardDeme extends AbstractDeme
{
    //--------------------------------------------------------------------
    private Genome active;


    //--------------------------------------------------------------------
    protected void select(
            List<Genome>   actors,
            Feedback       pressure,
            PrimordialSoup soup)
    {
        int distance = 0;
        for (Genome actor : new HashSet<Genome>(actors))
        {
            actor.cumulate( pressure.credit(distance++) );
        }
    }


    //--------------------------------------------------------------------
    protected Genome nextIndividual(List<Genome> outOf)
    {
        if (active == null)
        {
            active = Rand.fromList( outOf );
        }
        return active;
    }


    //--------------------------------------------------------------------
    public void didNotAct(Genome genome)
    {
        super.didNotAct( genome );
        active = null;
    }

    protected void afterSelection(PrimordialSoup soup)
    {
        if (Rand.nextDouble() < 0.2)
        {
            learn( soup );
        }
        active = null;
    }
}