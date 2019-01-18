package ao.ai.evo.gene;

import ao.ai.evo.coding.Coding;
import ao.ai.evo.gene.synthesis.RandomQueue;
import ao.ai.evo.genetic_material.GeneticMaterial;
import ao.ai.evo.heredity.Replicable;
import ao.ai.evo.product.Product;
import ao.ai.evo.promoter.Promoter;
import ao.ai.evo.promoter.affinity.Affinity;
import ao.util.rand.Rand;

import java.util.*;


/**
 * Genes interact with each other to influence physical
 *  development and behavior. Genes consist of a long strand
 *  of DNA (RNA in some viruses) that contains a promoter, which
 *  controls the activity of a gene, and a coding sequence,
 *  which determines what the gene produces.
 *
 * Immutable.
 */
public class Gene implements Replicable<Gene>
{
    //--------------------------------------------------------------------
    private static final Visitor SIZING_VISITOR = new SizingVisitor();
    private static class SizingVisitor implements Visitor
    {   public void visit(Locus details){}   }


    //--------------------------------------------------------------------
    private final Coding   coding;
    private final Promoter promoter;
    private final Gene     loci[];


    //--------------------------------------------------------------------
//    public Gene(Coding coding, Promoter promoter)
//    {
//        this(coding, promoter, new Gene[0]);
//    }
    public Gene(Coding coding, Promoter promoter, Gene loci[])
    {
        this.coding   = coding;
        this.promoter = promoter;
        this.loci     = loci;
    }


    //--------------------------------------------------------------------
    /**
     * @return amount of genetic material
     */
    public int size()
    {
        return postOrderTraverse(SIZING_VISITOR, 0)[0];
    }


    //--------------------------------------------------------------------
    public void postOrderTraverse(Visitor visitor)
    {
        postOrderTraverse(visitor, 0);
    }

    private int[] postOrderTraverse(Visitor visitor, int depth)
    {
        int size     = 1;
        int leafDist = -1;
        for (Gene geneAtLocus : loci)
        {
            int sizeAndDist[] =
                    geneAtLocus.postOrderTraverse(visitor, depth + 1);
            size += sizeAndDist[0];
            leafDist = Math.max(leafDist, sizeAndDist[1]);
        }

        visitor.visit(
                new Locus(this, leafDist + 1, depth, size) );
        return new int[]{size, leafDist + 1};
    }


    //--------------------------------------------------------------------
    public Promoter promoter()
    {
        return promoter;
    }

    public Coding coding()
    {
        return coding;
    }


    //--------------------------------------------------------------------
    public Product express()
    {
        return coding.encode(loci);
    }


    //--------------------------------------------------------------------
    // http://library.thinkquest.org/19037/therapy2.html

    public Gene microMutate(Gene restriction, GeneticMaterial addend)
    {
        return spliceAtOrBelow(restriction, addend.construct(null));
    }
    public Gene macroMutate(Gene restriction, Gene addend)
    {
        return spliceAtOrBelow(restriction, addend);
    }

    private Gene spliceAtOrBelow(Gene restriction, Gene addend)
    {
        if (equals( restriction ))
        {
            return splice(addend);
        }
        else
        {
            Gene splicedLoci[] = new Gene[ loci.length ];
            for (int i = 0; i < loci.length; i++)
            {
                splicedLoci[i] =
                        loci[i].spliceAtOrBelow(restriction, addend);
            }
            return new Gene(coding, promoter, splicedLoci);
        }
    }

    private Gene splice(Gene vector)
    {
        if (vector.loci == null)
        {
            assert promoter.isAffine( vector.promoter() )
                : promoter + " incompatible with " + vector.promoter();
            return new Gene(vector.coding,
                            vector.promoter,
                            scatter(replicateLoci(loci)));
        }
        else
        {
            assert promoter.productAffinity().isAffine(
                    vector.promoter.productAffinity())
                : promoter + " incompatible with " + vector.promoter;
            return vector.replicate();
        }
    }


    //--------------------------------------------------------------------
    public Gene cross(Gene with)
    {
        if (promoter.isAffine( with.promoter ))
        {
            Gene crossedLoci[] = new Gene[ promoter.loci() ];
            for (int i = 0; i < crossedLoci.length; i++)
            {
                crossedLoci[i] = loci[ i ].cross( with.loci[ i ] );
            }
            return new Gene(randomCoding(with), promoter, crossedLoci);
        }
        else
        {
            return randomGene(with);
        }
    }
    private Coding randomCoding(Gene that)
    {
        return (Rand.nextBoolean() ? this : that).coding;
    }
    private Gene randomGene(Gene that)
    {
        return (Rand.nextBoolean() ? this : that).replicate();
    }


    //--------------------------------------------------------------------
    public Gene replicate()
    {
//        return new Gene(coding, promoter, replicateLoci(loci));
        return this;
    }
    private Gene[] replicateLoci(Gene toReplicate[])
    {
        Gene lociReplica[] = new Gene[ toReplicate.length ];
        for (int i = 0; i < toReplicate.length; i++)
        {
            lociReplica[ i ] = toReplicate[i].replicate();
        }
        return lociReplica;
    }


    //--------------------------------------------------------------------
    private Gene[] scatter(Gene genes[])
    {
        Map<Affinity, RandomQueue<Gene>> byAffinity =
                new HashMap<Affinity, RandomQueue<Gene>>();
        Map<Affinity, List<Integer>> indexByAffinity =
                new HashMap<Affinity, List<Integer>>();

        for (int i = 0; i < genes.length; i++)
        {
            Affinity affinity = genes[i].promoter.productAffinity();

            RandomQueue<Gene> affinityClass = byAffinity.get(affinity);
            List<Integer> affinityIndex = indexByAffinity.get(affinity);

            if (affinityClass == null) {
                affinityClass = new RandomQueue<Gene>();
                affinityIndex = new ArrayList<Integer>();

                byAffinity.put(affinity, affinityClass);
                indexByAffinity.put(affinity, affinityIndex);
            }
            affinityClass.add(genes[i]);
            affinityIndex.add(i);
        }

        Gene[] scattered = new Gene[ genes.length ];
        for (Map.Entry<Affinity, RandomQueue<Gene>>
                affinityEntry : byAffinity.entrySet())
        {
            for (Integer index :
                    indexByAffinity.get(affinityEntry.getKey()))
            {
                scattered[ index ] =
                        affinityEntry.getValue().removeRandom();
            }
        }
        return scattered;
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return coding.toString();
    }

    public String toTreeString()
    {
        return toTreeString(0);
    }
    private String toTreeString(int atPly)
    {
        StringBuilder indent = new StringBuilder();
        for (int i = 0; i < atPly; i++)
        {
            indent.append("  ");
        }

        StringBuilder ret = new StringBuilder();

        ret.append(indent).append("(");
        ret.append(coding.toString());

        for (Gene geneAtLocus : loci)
        {
            ret.append("\n");
            ret.append(indent).append("  ");

            if (geneAtLocus == null)
            {
                ret.append(indent).append("  ...");
            }
            else
            {
                ret.append(geneAtLocus.toTreeString(atPly + 1));
            }
        }

        ret.append(")");
        return ret.toString();
    }


    //--------------------------------------------------------------------
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || !(o instanceof Gene)) return false;

        Gene gene = (Gene) o;
        return coding.equals(gene.coding) &&
               promoter.equals(gene.promoter) &&
               Arrays.equals(loci, gene.loci);
    }

    @Override
    public int hashCode()
    {
        int result;
        result = coding.hashCode();
        result = 31 * result + promoter.hashCode();
        result = 31 * result + Arrays.hashCode(loci);
        return result;
    }

    //--------------------------------------------------------------------
    public static interface Visitor
    {
        public void visit(Locus details);
    }
}

