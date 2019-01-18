package ao.ai.rl.problem.snakes;

import ao.ai.AiUtil;
import ao.ai.rl.Agent;
import ao.ai.sample.WallHugAi;
import ao.sw.engine.board.BoardArrangement;
import ao.sw.engine.board.Direction;
import ao.sw.engine.board.Matrix;
import ao.sw.engine.player.MoveSpecifier;
import ao.sw.engine.player.Player;
import ao.sw.engine.v2.Snake;
import ao.util.rand.Rand;
import com.google.inject.Inject;

import java.util.*;

/**
 *
 */
public class AgentPlayer implements Player
{
    //--------------------------------------------------------------------
    private static volatile int toughtCount = 0;

    private Agent thinker;
    

    //--------------------------------------------------------------------
    @Inject
    public AgentPlayer(Agent agent)
    {
        thinker = agent;
    }


    //--------------------------------------------------------------------
    public void startThinking() {}
    public void stopThinking()  {}


    //--------------------------------------------------------------------
    public void makeMove(
            BoardArrangement  boardArrangement,
            Snake             snake,
            MoveSpecifier     moveSpecifier,
            Collection<Snake> snakes)
    {
        if (snakes.isEmpty() ||
                Direction.availableFrom(
                        boardArrangement, snake.head()
                ).isEmpty())
        {
            // avoid pointless suicide
            new WallHugAi()
                    .makeMove(
                            boardArrangement,
                            snake,
                            moveSpecifier,
                            snakes);
        }
        else
        {
//            Collection<Direction> forbidden =
//                    (toughtCount > 1000000)
//                    ? forbiddenMoves(boardArrangement, snake)
//                    : Collections.<Direction>emptySet();
            Collection<Direction> forbidden = Collections.emptySet();

            Snake opponent = snakes.iterator().next();
            thinker.sense(new InputObject(boardArrangement,
                                          snake, opponent));

            for (int i = 0; i < 64; i++)
            {
                moveSpecifier.clearDirection();

                thinker.act(new OutputObject(moveSpecifier));

                Direction dir = moveSpecifier.latestDirection();
                if (dir == null ||
                        !dir.translate( snake.head() )
                                .availableIn(boardArrangement) ||
                        forbidden.contains( dir ))
                {
                    thinker.didNotAct();
                }
                else
                {
                    break;
                }
            }
        }

        toughtCount++;
    }

    private Collection<Direction> forbiddenMoves(
            BoardArrangement board,
            Snake            you)
    {
        SortedMap<Double, Direction> moves =
                new TreeMap<Double, Direction>( );

        Collection<Direction> avail =
                Direction.availableFrom(board, you.head() );
        for (Direction possibleMove : avail)
        {
            Matrix available =
                    AiUtil.availableArea(
                            board,
                            possibleMove.translate(you.head()),
                            33);
            double freeSpots = available.occupiedCount();

            while (moves.containsKey(freeSpots))
            {
                freeSpots = Rand.nextDouble() / 100.0;
            }
            moves.put( freeSpots, possibleMove );
        }

        Double greatestArea = moves.lastKey();
        Collection<Direction> forbidden = new ArrayList<Direction>();
        for (Map.Entry<Double, Direction> entry : moves.entrySet())
        {
            Double area = entry.getKey();
            if (area < 6 && area < (greatestArea / 2.0) ||
                    area < (greatestArea / 3.0))
            {
                forbidden.add( entry.getValue() );
            }
        }
        forbidden.remove( moves.get(greatestArea) );
        return forbidden;
    }

}
