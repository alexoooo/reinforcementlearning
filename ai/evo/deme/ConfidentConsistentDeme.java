package ao.ai.evo.deme;

import ao.ai.evo.genome.Genome;
import ao.ai.evo.fitness.Feedback;
import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.util.rand.Rand;

import java.util.List;
import java.util.HashSet;

/**
 *
 */
public class ConfidentConsistentDeme extends AbstractDeme
{
    //--------------------------------------------------------------------
    private Genome active;


    //--------------------------------------------------------------------
    protected void select(
            List<Genome> actors,
            Feedback pressure,
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
            active = randomUnconfident( outOf );
        }
        return active;
    }

    private Genome randomUnconfident(List<Genome> outOf)
    {
        Genome unconfident = Rand.fromList( outOf );
        int    confidence  = unconfident.fitnessConfidence();
        for (int i = 0; i < 16; i++)
        {
            Genome subject = Rand.fromList( outOf );
            if (confidence >= subject.fitnessConfidence())
            {
                unconfident = subject;
                confidence  = subject.fitnessConfidence();
                if (confidence == 0) break;
            }
        }
        return unconfident;
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

