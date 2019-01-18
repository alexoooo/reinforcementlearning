package ao.ai.rl.problem.regression;

import ao.ai.axiom.Num;
import ao.ai.rl.gp.op.TerminalReached;

/**
 *
 */
public class ApproximationError
{
    //--------------------------------------------------------------------
    private RealFunction deleget;


    //--------------------------------------------------------------------
    public ApproximationError(RealFunction ofFunction)
    {
        deleget = ofFunction;
    }


    //--------------------------------------------------------------------
    public InputCase nextInput()
    {
        return new InputCase( deleget.nextInput() );
    }


    //--------------------------------------------------------------------
    public Delta deltaFunction(InputCase forInput)
    {
        return new Delta( forInput.INPUT );
    }


    //--------------------------------------------------------------------
    public double errorFor(Delta result)
    {
        if (result.output == null) return Double.NaN;
        
        Num expected = deleget.outputFor( result.INPUT );
        return result.output.minus( expected ).value();
    }


    //--------------------------------------------------------------------
    public static class InputCase
    {
        private final Num INPUT;

        private InputCase(Num input)
        {
            INPUT = input;
        }

        public Num input()
        {
            return INPUT;
        }

        @Override
        public String toString()
        {
            return "Input";
        }
    }


    //--------------------------------------------------------------------
    public static class Delta
    {
        private final Num INPUT;
        private       Num output;

        private Delta(Num input)
        {
            INPUT = input;
        }

        public void output(Num val)
        {
            output = val;
            throw new TerminalReached();
        }

        @Override
        public String toString()
        {
            return "Delta";
        }
    }
}
