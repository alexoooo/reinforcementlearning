package ao.ai.rl.tourney;

import ao.ai.rl.Agent;
import ao.ai.rl.Environment;
import ao.util.rand.Rand;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 *
 */
public class ConcurrentTournament implements Tournament
{
    //--------------------------------------------------------------------
    public static final String AGENT_POOL_SIZE = "ct.aps";


    //--------------------------------------------------------------------
    private Environment     environment;
    private Provider<Agent> agentProvider;
    private int             agentPoolSize;

    private List<Agent>            agents;
    private BlockingQueue<Agent>   available;
    private Executor               executor;
    private Map<Agent, Comparable> ratings;


    //--------------------------------------------------------------------
    public ConcurrentTournament()
    {
        available = new LinkedBlockingQueue<Agent>();
        executor  = Executors.newCachedThreadPool();
        ratings   = new ConcurrentHashMap<Agent, Comparable>();
        agents    = new CopyOnWriteArrayList<Agent>();
    }


    //--------------------------------------------------------------------
    @Inject
    public void injectAgentPoolSize(
            @Named(AGENT_POOL_SIZE)
                int injectedAgentPoolSize)
    {
        agentPoolSize = injectedAgentPoolSize;
    }

    @Inject
    public void injectAjectProvider(
            Provider<Agent> injectedAgentProvider)
    {
        agentProvider = injectedAgentProvider;
    }

    @Inject
    public void injectEnvironment(Environment injectedEnvironment)
    {
        environment = injectedEnvironment;
    }


    //--------------------------------------------------------------------
    public void init()
    {
        for (int i = 0; i < agentPoolSize; i++)
        {
            Agent agent = agentProvider.get();

            agents.add( agent );
            ratings.put(agent, new EloRating());
            available.add( agent );
            environment.introduce( agent );
        }
    }


    //--------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public Agent bestOfBreed()
    {
        Agent      bestAgent  = null;
        Comparable bestRating = null;

        for (Agent agent : ratings.keySet())
        {
            Comparable rating = ratings.get( agent );
            if (bestAgent == null || bestRating.compareTo(rating) < 0 )
            {
                bestAgent  = agent;
                bestRating = rating;
            }
        }

        return bestAgent;
    }

    //--------------------------------------------------------------------
    public void runOnce()
    {
        if (Rand.nextDouble() < 0.0001)
        {
            System.out.println("!!!!!!!!!========!!!!!! " + new Date());
            for (Agent agent : agents)
            {
                System.out.println(
                        ratings.get(agent) + "\t" + agent);
            }
        }

        try
        {
            submitTasks();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private synchronized void submitTasks() throws Exception
    {
        int size = environment.nextSimulationSize();

        assert size <= agentPoolSize
                : "simulation requires " + size + "/" + agentPoolSize;

        final List<Agent> contestants = new ArrayList<Agent>();

        for (int i = 0; i < size; i ++)
        {
//            Agent agent = available.poll();
            contestants.add( available.take() );
        }

        executor.execute(new Runnable() {
            @SuppressWarnings("unchecked")
            public void run() {
                environment.simulate( contestants, ratings );
                for (Agent contestant : contestants)
                {
                    try
                    {
                        available.put( contestant );
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
