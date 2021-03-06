package ao.ai.rl.problem.snakes;

import ao.ai.axiom.Bool;
import ao.ai.axiom.Comparison;
import ao.ai.axiom.Num;
import ao.ai.evo.fitness.Feedback;
import ao.ai.rl.Agent;
import ao.ai.rl.Environment;
import ao.ai.rl.problem.snakes.axiom.Coord;
import ao.ai.rl.problem.snakes.axiom.Vec;
import ao.ai.rl.tourney.EloRating;
import ao.sw.control.Game;
import ao.sw.control.GameResult;
import ao.sw.control.SimpleSnakesGame;
import ao.sw.control.SnakesRunner;
import ao.sw.engine.player.Player;
import ao.util.rand.Rand;

import java.util.List;
import java.util.Map;

/**
 *
 */
public class SnakesEnvironment implements Environment<EloRating>
{
    //--------------------------------------------------------------------
    public SnakesEnvironment() {}


    //--------------------------------------------------------------------
    public EloRating introduce(Agent agent)
    {
        addBaseThoughts( agent );
        addSnakeThoughts( agent );
        return new EloRating();
    }

    private static void addBaseThoughts(Agent agent)
    {
        agent.thinkWith( Num.class        );
        agent.thinkWith( Bool.class       );
        agent.thinkWith( Comparison.class );
    }

    private static void addSnakeThoughts(Agent agent)
    {
        agent.thinkWith( Coord.class );
        agent.thinkWith( Vec.class   );
    }


    //--------------------------------------------------------------------
    public int nextSimulationSize()
    {
        return 2;
    }


    //--------------------------------------------------------------------
    public void simulate(
            List<Agent>           agents,
            Map<Agent, EloRating> ratings)
    {
        Player playerA = new AgentPlayer( agents.get(0) );
        Player playerB = new AgentPlayer( agents.get(1) );

        if (Rand.nextDouble() < 0.05)
        {
//            runDemo(playerA, playerB);
        }
        else
        {
            runFast(agents.get(0), agents.get(1),
                    playerA, playerB, ratings);
        }
    }

    //--------------------------------------------------------------------
    private void runFast(
            Agent  agentA,  Agent  agentB,
            Player playerA, Player playerB,
            Map<Agent, EloRating>  ratings)
    {
        Game game = nextGameInstance();
        game.start();
        if (Rand.nextBoolean())
        {
            game.addPlayer( playerA );
            game.addPlayer( playerB );
        }
        else
        {
            game.addPlayer( playerB );
            game.addPlayer( playerA );
        }

        GameResult result = game.waitUntilGameOver();
        game.stop();

        if (result.winner() == null)
        {
            ratings.get(agentA).updateRating(
                    ratings.get(agentB), 0);

            if (result.length() == 0)
            {
                agentA.reinforce( new Feedback(-5000) );
                agentB.reinforce( new Feedback(-5000) );
            }
            else if (result.length() == 1)
            {
                agentA.reinforce( new Feedback(0)    );
                agentB.reinforce( new Feedback(-5000) );
            }
            else
            {
                if (result.endedInSuicide())
                {
                    agentA.reinforce( new Feedback(result.length() - 5000) );
                    agentB.reinforce( new Feedback(result.length() - 5000) );
                }
                else
                {
                    agentA.reinforce( new Feedback(result.length()) );
                    agentB.reinforce( new Feedback(result.length()) );
                }
            }
        }
        else if (result.winner() == playerA)
        {
            ratings.get(agentA).updateRating(
                    ratings.get(agentB), 1);

            if (result.endedInSuicide())
            {
                agentA.reinforce( new Feedback(result.length() +  300) );
                agentB.reinforce( new Feedback(result.length() - 5000) );
            }
            else
            {
                agentA.reinforce( new Feedback(result.length() + 2000) );
                agentB.reinforce( new Feedback(result.length() - 2000) );
            }
        }
        else
        {
            ratings.get(agentA).updateRating(
                    ratings.get(agentB), -1);

            if (result.endedInSuicide())
            {
                agentA.reinforce( new Feedback(result.length() - 5000) );
                agentB.reinforce( new Feedback(result.length() +  300) );
            }
            else
            {
                agentA.reinforce( new Feedback(result.length() - 2000) );
                agentB.reinforce( new Feedback(result.length() + 2000) );
            }
        }
    }

    //--------------------------------------------------------------------
    private void runDemo(Player playerA, Player playerB)
    {
        SnakesRunner.asynchDemoMatch(
                    15, 15,
                    playerA, playerB);
    }


    //--------------------------------------------------------------------
    private Game nextGameInstance()
    {
        return new SimpleSnakesGame(nextWidth(), nextHeight());
    }

    private int nextWidth()
    {
        return 10 + Rand.nextInt(10);
//        return 15;
    }
    private int nextHeight()
    {
        return 10 + Rand.nextInt(10);
//        return 15;
    }
}
