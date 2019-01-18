package ao.ai.evo.primordial_soup;

import ao.ai.evo.genetic_material.GeneticMaterial;
import ao.ai.evo.promoter.Promoter;
import ao.ai.evo.promoter.affinity.Affinity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
public class GeneDistiller
{
    /**
     * Useful Affinities are those returned by an independant promoter
     *
     * Only genes with promoters consisting entirely
     *  of useful Affinities are returned.
     *
     * @param genes toDistill
     * @return distilled
     */
    public GenePool distill(GenePool genes)
    {
        Set<Affinity> inependantlyProduced = new HashSet<Affinity>();
        for (GeneticMaterial material : genes.material())
        {
            if (material.promoter().isIndependent())
            {
                inependantlyProduced
                        .add( material.promoter().productAffinity() );
            }
        }

        GenePool distilled = new GenePool();
        for (GeneticMaterial material : genes.material())
        {
            if (onlyUses(material.promoter(), inependantlyProduced))
            {
                distilled.add( material );
            }
        }

        return distilled;
    }

    private boolean onlyUses(
            Promoter             promoter,
            Collection<Affinity> affinities)
    {
        if (! affinities.contains(
                promoter.productAffinity() )) return false;

        for (Affinity locus : promoter.lociAffinities())
        {
            if (! affinities.contains(locus) ) return false;
        }

        return true;
    }

}
