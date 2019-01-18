package ao.ai.evo.gene.synthesis;

import ao.ai.evo.gene.Gene;
import ao.ai.evo.primordial_soup.PrimordialSoup;
import ao.ai.evo.promoter.affinity.Affinity;
import ao.ai.evo.chromosome.config.TreeGenParams;
import ao.ai.evo.genetic_material.GeneticMaterial;
import com.google.inject.Singleton;

/**
 *
 */
@Singleton
public class GeneSynthesizerImpl implements GeneSynthesizer
{
    //--------------------------------------------------------------------
    public GeneSynthesizerImpl() {}


    //--------------------------------------------------------------------
    public Gene synthesize(
            TreeGenParams  params,
            Affinity       returning,
            PrimordialSoup ops)
    {
        int goalSize = params.maxSize();
        int maxDepth = params.maxLeafDistance();

        assert goalSize >= 1 : goalSize + " is too small.";
        assert maxDepth >= 1 : goalSize + " is too shallow.";

        return (goalSize == 1)
                ? newTemplate(ops, returning, true).construct()
                : fillRandom(returning, ops, goalSize, maxDepth);
    }

    private Gene fillRandom(
            Affinity       returning,
            PrimordialSoup ops,
            int            goalSize,
            int            maxDepth)
    {
        int                     size   = 1;
        RandomQueue<OpenBranch> toFill = new RandomQueue<OpenBranch>();

        GeneTemplate root = newTemplate(ops, returning, false);
        OpenBranch.addArgsOf(root, toFill, 1);

        while (toFill.size() + size <= goalSize &&
               ! toFill.isEmpty())
        {
            OpenBranch unfilled = toFill.removeRandom();
            GeneTemplate filler   = unfilled.fill(ops, maxDepth);

            OpenBranch.addArgsOf(filler, toFill, unfilled.nextDepth());

            size++;
        }

        while (! toFill.isEmpty())
        {
            toFill.removeRandom().fill(ops, 0);
        }

        return root.construct();
    }


    //--------------------------------------------------------------------
    private static GeneTemplate newTemplate(
            PrimordialSoup ops,
            Affinity    returning,
            boolean     terminal)
    {
        return new GeneTemplate( ops.synthesize(returning, terminal) );
    }


    //--------------------------------------------------------------------
    private static class GeneTemplate
    {
        private final GeneticMaterial material;
        private final GeneTemplate    loci[];

        public GeneTemplate(GeneticMaterial material)
        {
            this.material = material;
            this.loci     = new GeneTemplate[
                                    material.promoter().loci() ];
        }

        public boolean isAvailable(int locus)
        {
            return loci[ locus ] == null;
        }

        public void fill(int position, GeneTemplate filler)
        {
            loci[ position ] = filler;
        }

        public Gene construct()
        {
            Gene constructedLoci[] = new Gene[ loci.length ];
            for (int i = 0; i < loci.length; i++)
            {
                constructedLoci[ i ] = loci[ i ].construct();
            }
            return material.construct( constructedLoci );
        }
    }


    //--------------------------------------------------------------------
    private static class OpenBranch
    {
        public static void addArgsOf(
                GeneTemplate            tree,
                RandomQueue<OpenBranch> to,
                int                     atDepth)
        {
            for (int i = 0; i < tree.loci.length; i++)
            {
                if (tree.isAvailable(i))
                {
                    to.add( new OpenBranch(tree, i, atDepth) );
                }
            }
        }

        //----------------------------------------------------------------
        private final GeneTemplate TEMPLATE;
        private final int          DEPTH;
        private final int          POSITION;
        private final Affinity     TYPE;

        //----------------------------------------------------------------
        private OpenBranch(GeneTemplate of, int atPosition, int atDepth)
        {
            TYPE     = of.material.promoter().locusAffinity(atPosition);
            TEMPLATE = of;
            DEPTH    = atDepth;
            POSITION = atPosition;
        }

        //----------------------------------------------------------------
        public int nextDepth()
        {
            return DEPTH + 1;
        }

        //----------------------------------------------------------------
        public GeneTemplate fill(PrimordialSoup from, int upToDepth)
        {
            boolean terminal = DEPTH >= upToDepth;
            GeneTemplate filler = newTemplate( from, TYPE, terminal );
            TEMPLATE.fill(POSITION, filler);
            return filler;
        }
    }
}

