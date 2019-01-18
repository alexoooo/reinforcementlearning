package ao.ai.evo.gene.synthesis;

import ao.ai.evo.gene.Gene;
import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.ai.evo.promoter.affinity.GpAffinity;
import ao.ai.evo.chromosome.config.TreeGenParams;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 *
 */
@Singleton
public class RandomGeneSynthesizer
{
    //--------------------------------------------------------------------
    private GeneSynthesizer treeBuilder;
    private TreeGenParams   treeGenParams;

    //--------------------------------------------------------------------
    public RandomGeneSynthesizer() {}


    //--------------------------------------------------------------------
    @Inject
    public void injectTreeBuilder(GeneSynthesizer injectedTreeBuilder)
    {
        treeBuilder  = injectedTreeBuilder;
    }

    @Inject
    public void injectTreeBuilder(TreeGenParams injectedTreeGenParams)
    {
        treeGenParams = injectedTreeGenParams;
    }


    //--------------------------------------------------------------------
    public Gene randomInstance(PrimordialSoup ops)
    {
        return treeBuilder.synthesize(
                treeGenParams.constrain(1000, 10),
                new GpAffinity(Object.class),
                ops);
    }
}
