package ao.ai.evo.chromosome;

import ao.ai.evo.gene.Gene;
import ao.ai.evo.gene.synthesis.GeneSynthesizer;
import ao.ai.evo.gene.synthesis.WeightedLocus;
import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.ai.evo.chromosome.config.LocusChooser;
import ao.ai.evo.chromosome.config.MacroMutationProb;
import ao.ai.evo.chromosome.config.TreeGenParams;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 *
 */
@Singleton
public class MacroMutator
{
    //--------------------------------------------------------------------
    private GeneSynthesizer treeBuilder;
    private TreeGenParams     treeGenParams;
    private MacroMutationProb probs;


    //--------------------------------------------------------------------
    public MacroMutator() {}


    //--------------------------------------------------------------------
    @Inject
    public void injectMutateTreeProbs(MacroMutationProb injectedProbs)
    {
        probs = injectedProbs;
    }

    @Inject
    public void injectTreeGenParams(TreeGenParams injectedTreeGenParams)
    {
        treeGenParams = injectedTreeGenParams;
    }

    @Inject
    public void injectTreeBuilder(GeneSynthesizer injectedTreeBuilder)
    {
        treeBuilder = injectedTreeBuilder;
    }


    //--------------------------------------------------------------------
    public Gene macroMutate(Gene tree, PrimordialSoup thoughts)
    {
        for (int i = 0; i < 10; i++)
        {
            WeightedLocus choice =
                LocusChooser.Maximizer.maximize( tree, probs );

            if (choice != null &&
                    choice.weight().isUsable())
            {
                Gene mutation =
                        treeBuilder.synthesize(
                                treeGenParams.constrainMacro(tree, choice),
                                choice.gene().promoter().productAffinity(),
                                thoughts);
//                System.out.println("macro mutated!!");
                return tree.macroMutate( choice.gene(), mutation );
            }
        }
//        System.out.println("did not macro");
        return tree.replicate();
    }
}
