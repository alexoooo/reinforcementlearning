package ao.ai.rl.problem.regression;

import ao.ai.axiom.Num;

/**
 *
 */
public interface RealFunction
{
    //--------------------------------------------------------------------
    public Num nextInput();

    public Num outputFor(Num input);
}
