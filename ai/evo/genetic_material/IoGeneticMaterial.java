package ao.ai.evo.genetic_material;

import ao.ai.evo.coding.IoCoding;
import ao.ai.evo.gene.Gene;
import ao.ai.evo.promoter.GpPromoter;

/**
 *
 */
public class IoGeneticMaterial<T> extends GeneticMaterial
{
    //--------------------------------------------------------------------
    private final IoCoding<T> CODING;


    //--------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public IoGeneticMaterial(T value)
    {
        super(new IoCoding<T>(value),
              new GpPromoter(value.getClass()));

        CODING = (IoCoding<T>) construct(new Gene[0]).coding();
    }


    //--------------------------------------------------------------------
    public void replaceWith(T value)
    {
        CODING.replaceWith( value );
    }
}
