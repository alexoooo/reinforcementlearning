package ao.ai.rl.gp.agent;

import ao.ai.rl.Agent;
import ao.ai.rl.gp.agent.params.*;
import ao.util.rand.Rand;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * 
 */
public class AlexoAgentProvider implements Provider<Agent>
{
    //--------------------------------------------------------------------
    public AlexoAgentProvider() {}


    //--------------------------------------------------------------------
    public Agent get()
    {
//        FlexConfigParams params = new FlexConfigParams();
        FlexConfigParams params =
                new FlexConfigParams(
                        MacroMutationSizeLimit.EIGHT,
                        MacroMutationDepthLimit.FOUR,
                        Rand.fromArray(MacroMutationWeight.values()),
                        Rand.fromArray(MicroMutationWeight.values()),
                        Rand.fromArray(RecombinationWeight.values()),
//                        Rand.fromArray(PopulationType.values()),
                        PopulationType.MULTI,
                        PopulationSize.OUT_THOUSAND_TWENTY_FOUR,
                        TreeSizeLimit.SIXTY_FOUR,
                        TreeDepthLimit.NINE
                );
        FlexConfig       config = new FlexConfig( params );

        Injector injector =
                Guice.createInjector( config );

        AlexoAgent agent =
                injector.getInstance( AlexoAgent.class );
        agent.setupKey( params );

        return agent;
    }
}
