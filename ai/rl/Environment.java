package ao.ai.rl;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface Environment<R extends Comparable<R>>
{
    public R introduce(Agent agent);

    public int nextSimulationSize();
    
    public void simulate(
            List<Agent>   agents,
            Map<Agent, R> ratings);
}
