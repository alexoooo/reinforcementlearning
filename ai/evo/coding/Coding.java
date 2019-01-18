package ao.ai.evo.coding;

import ao.ai.evo.product.Product;
import ao.ai.evo.gene.Gene;

/**
 * Immutable.
 */
public interface Coding
{
    public Product encode(Gene... dependencies);
}
