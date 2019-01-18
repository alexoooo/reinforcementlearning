package ao.ai.rl.problem.regression.function;

import ao.ai.rl.problem.regression.RealFunction;
import ao.ai.axiom.Num;
import ao.util.rand.Rand;

/**
 *
 */
public class LinearFunction implements RealFunction
{
    //--------------------------------------------------------------------
    public Num nextInput()
    {
        return new Num( Rand.nextDouble(64) - 32 );
    }

    public Num outputFor(Num input)
    {
        return new Num( input.value() * 2 - 3 );
    }
}
