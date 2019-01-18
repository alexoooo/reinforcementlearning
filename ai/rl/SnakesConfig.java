package ao.ai.rl;

import ao.ai.rl.problem.snakes.SnakesEnvironment;
import ao.ai.rl.tourney.ConcurrentTournament;
import ao.ai.rl.tourney.Tournament;
import ao.ai.rl.gp.agent.AlexoAgentProvider;
import com.google.inject.AbstractModule;
import static com.google.inject.name.Names.named;

/**
 * 
 */
public class SnakesConfig extends AbstractModule
{
    //--------------------------------------------------------------------
    protected void configure()
    {
        bind(Agent.class).toProvider(AlexoAgentProvider.class);

        bind(Tournament.class)
                .to(ConcurrentTournament.class);
        bindConstant().annotatedWith(
                named(ConcurrentTournament.AGENT_POOL_SIZE)
        ).to(4);

        bind(Environment.class)
                .to(SnakesEnvironment.class);
    }
}
