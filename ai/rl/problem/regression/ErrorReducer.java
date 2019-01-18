package ao.ai.rl.problem.regression;

import ao.ai.evo.fitness.Feedback;
import ao.ai.rl.Agent;
import ao.ai.axiom.Num;
import ao.ai.axiom.Bool;

import java.util.LinkedList;

/**
 *
 */
public class ErrorReducer
{
    //--------------------------------------------------------------------
    private final Agent              AGENT;
    private final ApproximationError APROX;

    private LinkedList<Double> errors = new LinkedList<Double>();
    private double             errorSum;

    //--------------------------------------------------------------------
    public ErrorReducer(Agent agent, RealFunction aprox)
    {
        agent.thinkWith( Num.class  );
        agent.thinkWith( Bool.class );

        AGENT = agent;
        APROX = new ApproximationError( aprox );
    }


    //--------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public double attemptReduce()
    {
        ApproximationError.InputCase input = APROX.nextInput();
        ApproximationError.Delta     delta = APROX.deltaFunction(input);

        AGENT.sense( input );
        AGENT.act( delta );

        double error = APROX.errorFor( delta );
        if (Double.isNaN( error ))
        {
            AGENT.didNotAct();
        }
        else
        {
            double absError = Math.abs(error);
            AGENT.reinforce( new Feedback(-absError*absError) );
            if (absError < 1000)
            {
                updateAverage(absError);
            }
        }

        return runningAverage();
//        return error;
    }

    private void updateAverage(double error)
    {
        if (errors.size() >= 128)
        {
            errorSum -= errors.removeLast();
        }
        errors.addFirst( error );
        errorSum += error;
    }

    private double runningAverage()
    {
        return errorSum / errors.size();
    }
}
