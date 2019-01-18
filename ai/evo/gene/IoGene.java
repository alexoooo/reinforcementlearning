package ao.ai.evo.gene;

import ao.ai.evo.coding.IoCoding;
import ao.ai.evo.promoter.GpPromoter;

/**
 *
 */
public class IoGene<T> extends Gene
{
    //--------------------------------------------------------------------
    public IoGene(T value)
    {
        super(new IoCoding<T>(value),
              new GpPromoter(value.getClass()),
              new Gene[0]);
    }


    //--------------------------------------------------------------------
    @SuppressWarnings("unchecked")
    public void replaceWith(T value)
    {
        ((IoCoding<T>) coding()).replaceWith( value );
    }
}
