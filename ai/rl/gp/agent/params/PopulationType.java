package ao.ai.rl.gp.agent.params;

import ao.ai.evo.deme.*;

/**
 *
 */
public enum PopulationType
{
    CONSISTENT_CONFIDENT(ConfidentConsistentDeme.class),
    CONSISTENT_REWARD(ConsistentRewardDeme.class),
    CONSISTENT(ConsistentDeme.class),
//    RANDOM(RandomDeme.class),
    MULTI(MultiDeme.class)
    ;

    private final Class<? extends Deme> value;

    private PopulationType(Class<? extends Deme> val)
    {
        value = val;
    }

    public Class<? extends Deme> type()
    {
        return value;
    }

    @Override
    public String toString()
    {
        return "pop=" + value.getSimpleName();
    }
}
