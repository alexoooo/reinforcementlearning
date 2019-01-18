package ao.ai.rl;

import ao.ai.rl.gp.agent.AlexoAgentProvider;
import ao.ai.rl.problem.regression.ErrorReducer;
import ao.ai.rl.problem.regression.function.LinearFunction;
import ao.ai.rl.problem.snakes.AgentPlayer;
import ao.ai.rl.tourney.Tournament;
import ao.ai.sample.monte_carlo.UctAi;
import ao.sw.control.SnakesRunner;
import ao.util.rand.Rand;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Provider;


/**
 *
 */
public class AgentTest
{
    //--------------------------------------------------------------------
    public static void main(String[] args)
    {
        // throw off number sequence
//        Rand.nextInt();
        Rand.nextDouble();

        runSnakes();
//        runErrorReducer();
//        runPoker();
    }

    //----------------------------------------------------------
    public static void runSnakes()
    {
        Injector injector =
                Guice.createInjector(
                        new SnakesConfig());

        Tournament problem =
                injector.getInstance(Tournament.class);

        problem.init();
        for (int i = 1; i < Integer.MAX_VALUE; i++)
        {
            problem.runOnce();
            if (i % 1000 == 0)
            {
                snakesTest( problem.bestOfBreed() );
            }
        }
    }

    private static void snakesTest(Agent vs)
    {
//        System.out.println(Stringer.toString( vs ));

        SnakesRunner.asynchDemoMatch(
                25, 25,
//                new ForkPathAi(),
//                new RandomAi(),
                new UctAi(64),
                new AgentPlayer( vs ));
    }


    //--------------------------------------------------------------------
    public static void runErrorReducer()
    {
        Provider<Agent> agentProvider = new AlexoAgentProvider();
        Agent           agent         = agentProvider.get();

        ErrorReducer reducer =
                new ErrorReducer(
                        agent,
                        new LinearFunction());

        for (int i = 0; i < Integer.MAX_VALUE; i++)
        {
            double error = reducer.attemptReduce();

            if (i % 1000 == 0)
            {
                System.out.println(error);
            }
        }
    }
}


