package ao.ai.evo.fitness;

import ao.util.stats.Stats;

/**
 *
 */
public class Fitness implements Comparable<Fitness>
{
    //--------------------------------------------------------------------
    private final double cumulative;
    private final int    confidence;


    //--------------------------------------------------------------------
    public Fitness()
    {
        this(0, 0);
    }
    public Fitness(double value)
    {
        this(adjust(value), 1);
    }

    private Fitness(double val, int count)
    {
        cumulative = val;
        confidence = count;
    }


    //--------------------------------------------------------------------
    public int confidence()
    {
        return confidence;
    }


    //--------------------------------------------------------------------
    public Fitness cumulate(Fitness delta)
    {
        double d  = 1.0 - 1.0/(1 + Math.sqrt(Math.abs(delta.cumulative)));
        double dd = 0.5 + Double.compare(delta.cumulative, 0) * d / 2;

        double expectedDelta =
                1.0 / (1 + Math.pow(10,
                                    (delta.cumulative - cumulative)/400));
        
        return new Fitness(cumulative + 5 * (dd - expectedDelta),
                           confidence + delta.confidence);
//        return new Fitness(cumulative + delta.cumulative,
//                           confidence + delta.confidence);
    }

    public Fitness reduce()
    {
        return new Fitness((cumulative == 0)
                            ? -10
                            : (cumulative > 0)
                               ? cumulative / 2
                               : cumulative * 2,
                            confidence + 1);
    }


    //--------------------------------------------------------------------
    private double value()
    {
        return (confidence == 0)
                ? 0
                : Stats.accountForStatisticalError(
                            cumulative, confidence);
    }

    private static double adjust(double val)
    {
//        return Math.signum(val) * Math.sqrt( Math.abs(val) );
        return val;
    }


    //--------------------------------------------------------------------
    public int compareTo(Fitness o)
    {
        return (int)((value() - o.value()) * 10);
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return String.valueOf( value() );
    }
}

