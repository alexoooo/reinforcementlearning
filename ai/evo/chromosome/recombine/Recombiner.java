package ao.ai.evo.chromosome.recombine;

import ao.ai.evo.chromosome.config.CrossoverDestinationProb;
import ao.ai.evo.chromosome.config.TreeGenParams;
import ao.ai.evo.gene.Gene;
import com.google.inject.Inject;

/**
 * sexual recombination
 */
public class Recombiner
{
    //--------------------------------------------------------------------
    private CrossoverDestinationProb destProbs;
    private TreeGenParams            params;


    //--------------------------------------------------------------------
    public Recombiner() {}


    //--------------------------------------------------------------------
    @Inject
    public void injectCrossoverProbs(
            CrossoverDestinationProb injectedProbs)
    {
        destProbs = injectedProbs;
    }

    @Inject
    public void injectTreeGenProbs(TreeGenParams injectedTreeGenParams)
    {
        params = injectedTreeGenParams;
    }


    //--------------------------------------------------------------------
    public Gene cross(
            Gene destinationTree, Gene sourceTree)
    {
        return destinationTree.cross( sourceTree ); 
//        for (int tryCount = 0; tryCount < 10; tryCount++)
//        {
//            WeightedLocus destinationLocus =
//                    LocusChooser.Maximizer.maximize(
//                            destinationTree, destProbs);
//
//            int targetTreeSize = params.maxSize();
//            int maxSourceSize   =
//                    Math.max((targetTreeSize - destinationTree.size())
//                                + destinationLocus.size(), 1);
//
//            WeightedLocus source =
//                    LocusChooser.Maximizer.maximize(
//                            destinationTree,
//                            new CrossoverSourceProb(
//                                    maxSourceSize,
//                                    destinationLocus.gene()));
//            if (source != null &&
//                source.weight().isUnusable())
//            {
////                if ((destinationLocus.size() - source.size()) > 8)
////                {
////                    System.out.println("!!");
////                }
//
//                System.out.println("crossed!!");
//                return destinationTree.macroMutate(
//                        destinationLocus.gene(),
//                        source.gene());
//            }
//        }
////        System.out.println("did not cross");
//        return destinationTree.replicate();
    }
}
