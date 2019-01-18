package ao.ai.rl;

import ao.ai.evo.fitness.Feedback;

/**
 * A reinforcement learning agent.
 */
public interface Agent
{
    /**
     * Called when something happens in the
     *  environment.
     *
     * @param input must be immutable.
     */
    public void sense(Object input);


    /**
     * Asked to interact with with an object.
     *
     * @param on [move specifier]
     */
    public void act(Object on);


    /**
     * The agent will attempt to maximize the
     *  sum of rewards.
     *
     * @param reward +- reward/punishment
     */
    public void reinforce(Feedback reward);

    public void didNotAct();


    /**
     * Agent will think by composing
     *  its given concepts.
     *
     * @param concept [elementary thought]
     */
    public void thinkWith(Object concept);
}
