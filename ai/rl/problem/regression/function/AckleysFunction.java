package ao.ai.rl.problem.regression.function;

import ao.ai.axiom.Num;
import ao.ai.rl.problem.regression.RealFunction;
import ao.util.rand.Rand;

/**
 *
 */
public class AckleysFunction implements RealFunction
{
    //--------------------------------------------------------------------
    public Num nextInput()
    {
        return new Num(Rand.nextDouble(64) - 32);
    }

    public Num outputFor(Num input)
    {
        return new Num(valueAt( input.value() ));
    }


    //--------------------------------------------------------------------
    private double valueAt(double x)
    {
        return -20.0 *
               Math.exp(-0.2 * Math.sqrt(
                                 1.0/30 * sumOfSquares(x, 30)))
                * -Math.exp(1.0/30 * sumOfTrig(x, 30))
                + 20 + Math.E;
    }

    private double sumOfTrig(double x, int nTimes)
    {
        double sum = 0;
        for (int i = 0; i < nTimes; i++)
        {
            sum += Math.cos(2.0 * Math.PI * x);
        }
        return sum;
    }

    private double sumOfSquares(double x, int nTimes)
    {
        double sum = 0;
        for (int i = 0; i < nTimes; i++)
        {
            sum += x * x;
        }
        return sum;
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "Ackley's Function";
    }
}
