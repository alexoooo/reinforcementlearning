package ao.ai.rl.gp.agent.niche;

import ao.ai.evo.deme.niche.Community;
import ao.ai.evo.fitness.Feedback;
import ao.ai.evo.genetic_material.IoGeneticMaterial;
import ao.ai.evo.genome.NicheGenome;
import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.ai.rl.Agent;

/**
 * See [Rosca 97].
 */
public class NicheAgent implements Agent
{
    //--------------------------------------------------------------------
    private PrimordialSoup outputGenes;
    private PrimordialSoup conditionGenes;

    private boolean initedInput = false;
    private boolean initedSense = false;
    private IoGeneticMaterial actionObject;
    private IoGeneticMaterial inputObject;

    private Object      key;
    private Community   pop;
    private NicheGenome actor;


    //--------------------------------------------------------------------
    public NicheAgent()
    {
        pop            = new Community();
        outputGenes    = new PrimordialSoup();
        conditionGenes = new PrimordialSoup();
    }

    public void setupKey(Object key)
    {
        this.key = key;
    }
    

    //--------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public synchronized void sense(Object input)
    {
        assert !(input instanceof Class)
                : "cannot sense class objects";

        if (! initedSense)
        {
            inputObject = new IoGeneticMaterial<Object>(input);

            outputGenes.addSingleton( inputObject      );
            outputGenes.addMethods(   input.getClass() );
            conditionGenes.addSingleton( inputObject      );
            conditionGenes.addMethods(   input.getClass() );

            initedSense = true;
        }
        else
        {
            inputObject.replaceWith( input );
        }

//        buffer(input);
    }


    //--------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public synchronized void act(Object on)
    {
//        if (! initedInput)
//        {
//            actionObject = new IoGene(on);
//
//            outputGenes.addSingleton( actionObject );
//            outputGenes.addMethods( on.getClass() );
//
//            conditionGenes.addSingleton( inputObject      );
//            conditionGenes.addMethods(   input.getClass() );
//
//            initedInput = true;
//        }
//        else
//        {
//            actionObject.replaceWith( on );
//        }
//
//        if (actor != null)
//        {
//            pop.actionPerformed( actor );
//        }
//        actor = pop.nextIndividual( thinkWith );
//        actor.evaluate();
    }


    //--------------------------------------------------------------------
    public synchronized void reinforce(Feedback reward)
    {

    }


    //--------------------------------------------------------------------
    public synchronized void didNotAct()
    {

    }

    
    //--------------------------------------------------------------------
    public synchronized void thinkWith(Object concept)
    {

    }
}
