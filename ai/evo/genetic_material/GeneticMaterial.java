package ao.ai.evo.genetic_material;

import ao.ai.evo.coding.Coding;
import ao.ai.evo.gene.Gene;
import ao.ai.evo.promoter.Promoter;

/**
 *
 */
public class GeneticMaterial
{
    //--------------------------------------------------------------------
    private final Coding   coding;
    private final Promoter promoter;
    

    //--------------------------------------------------------------------
    public GeneticMaterial(GeneticMaterial gene, Promoter maskingPromoter)
    {
        this(gene.coding, maskingPromoter);
    }
    public GeneticMaterial(Coding coding, Promoter promoter)
    {
        this.coding   = coding;
        this.promoter = promoter;
    }


    //--------------------------------------------------------------------
    public Promoter promoter()
    {
        return promoter;
    }

    public Gene construct(Gene loci[])
    {
        return new Gene(coding, promoter, loci);
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return String.valueOf( coding );
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || !(o instanceof GeneticMaterial)) return false;

        GeneticMaterial that = (GeneticMaterial) o;
        return coding.equals( that.coding ) &&
                promoter.equals( that.promoter );
    }

    @Override
    public int hashCode()
    {
        return coding.hashCode() +
               31 * promoter.hashCode();
    }
}
