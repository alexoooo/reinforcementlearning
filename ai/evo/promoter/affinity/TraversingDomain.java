package ao.ai.evo.promoter.affinity;

import java.util.*;

/**
 *
 */
public class TraversingDomain implements AffinityDomain
{
    //--------------------------------------------------------------------
    private Set<Affinity> baseAffinities;
    private Set<Affinity> singletonAffinities;


    //--------------------------------------------------------------------
    public TraversingDomain()
    {
        baseAffinities      = new HashSet<Affinity>();
        singletonAffinities = new HashSet<Affinity>();
    }


    //--------------------------------------------------------------------
    public boolean contains(Affinity baseAffinity)
    {
        return baseAffinities.contains( baseAffinity ) ||
               singletonAffinities.contains( baseAffinity );
    }

    //--------------------------------------------------------------------
    public boolean add(Affinity baseAffinity)
    {
        assert !singletonAffinities.contains( baseAffinity )
                : baseAffinity + " is a singleton.";
        return baseAffinities.add( baseAffinity  );
    }

    public boolean addSingleton(Affinity baseAffinity)
    {
        assert !baseAffinities.contains( baseAffinity )
                : baseAffinity + " not singleton.";
        return singletonAffinities.add( baseAffinity );
    }


    //--------------------------------------------------------------------
    public Collection<Affinity> loosen(Affinity affinity)
    {
        return affinity.affineSet();
    }

    public Collection<Affinity> tighten(Affinity affinity)
    {
        if (singletonAffinities.contains(affinity))
        {
            return Arrays.asList(affinity);
        }

        Set<Affinity> subclasses = new HashSet<Affinity>();

        subclasses.add( affinity );
        for (Affinity anAffinity : baseAffinities)
        {
            if (affinity.isAffine(anAffinity))
            {
                subclasses.add( anAffinity );
            }
        }

        return Collections.unmodifiableCollection(subclasses);
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return baseAffinities.toString();
    }
}
