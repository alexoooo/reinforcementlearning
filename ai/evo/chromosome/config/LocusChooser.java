package ao.ai.evo.chromosome.config;

import ao.ai.evo.gene.Gene;
import ao.ai.evo.gene.Locus;
import ao.ai.evo.gene.synthesis.WeightedLocus;

/**
 *
 */
public interface LocusChooser
{
    //--------------------------------------------------------------------
    public LocusWeight branchUseWeight(
            Locus branchDetails);


    //--------------------------------------------------------------------
    public static class Maximizer
    {
        public static WeightedLocus maximize(
                Gene in, LocusChooser weightOf)
        {
            return new MaximizingVisitor().doMaximize(in, weightOf);
        }
    }


    //--------------------------------------------------------------------
    public static class MaximizingVisitor
            implements Gene.Visitor
    {
        //----------------------------------------------------------------
        private WeightedLocus maxWeightBranch;
        private LocusWeight maxWeight = LocusWeight.UNUSABLE;
        private LocusChooser chooser;

        //----------------------------------------------------------------
        private MaximizingVisitor() {}

        //----------------------------------------------------------------
        private WeightedLocus doMaximize(
                Gene in, LocusChooser weightOf)
        {
            chooser = weightOf;
            in.postOrderTraverse( this );
            return maxWeightBranch;
        }

        //----------------------------------------------------------------
        public void visit(Locus details)
        {
            LocusWeight weight = chooser.branchUseWeight(details);
            if (weight.compareTo(maxWeight) > 0)
            {
                maxWeight       = weight;
                maxWeightBranch = new WeightedLocus(details, weight);
            }
        }
    }
}
