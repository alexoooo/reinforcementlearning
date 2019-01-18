package ao.ai.rl.problem.snakes;

import ao.ai.axiom.Num;
import ao.ai.rl.gp.op.TerminalReached;
import ao.sw.engine.board.Direction;
import ao.sw.engine.player.MoveSpecifier;

/**
 *
 */
public class OutputObject
{
    //--------------------------------------------------------------------
    private static final double NORTH_UPPER = 3.0/4 * Math.PI;
    private static final double NORTH_LOWER = 1.0/4 * Math.PI;

    private static final double WEST_UPPER = 5.0/4 * Math.PI;
    private static final double WEST_LOWER = NORTH_UPPER;

    private static final double SOUTH_UPPER = 7.0/4 * Math.PI;
    private static final double SOUTH_LOWER = WEST_UPPER;


    //--------------------------------------------------------------------
    private final MoveSpecifier deleget;


    //--------------------------------------------------------------------
    public OutputObject(MoveSpecifier moveSpecifier)
    {
        deleget = moveSpecifier;
    }


    //--------------------------------------------------------------------
    public void setDirection(Num angle)
    {
        // -2*PI < rads < 2*PI
        double rads = angle.remainder( Num.twoPi() ).value();
        if (rads < 0) rads = Num.twoPi().value() + rads;

        Direction dir =
                (NORTH_UPPER >= rads && rads > NORTH_LOWER)
                ? Direction.NORTH
                : (WEST_UPPER >= rads && rads > WEST_LOWER)
                  ? Direction.WEST
                  : (SOUTH_UPPER >= rads && rads > SOUTH_LOWER)
                    ? Direction.SOUTH
                    : Direction.EAST;

        deleget.setDirection(dir);
        throw new TerminalReached();
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "Snakes Output";
    }
}
