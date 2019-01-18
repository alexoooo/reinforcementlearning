package ao.ai.evo.gene;

/**
 *
 */
public class Locus
{
    //--------------------------------------------------------------------
    private final Gene branch;
    private final int  maxLeafDistance;
    private final int  rootDistance;
    private final int  size;


    //--------------------------------------------------------------------
    public Locus(Locus copyDetails)
    {
        this(copyDetails.branch,
             copyDetails.maxLeafDistance,
             copyDetails.rootDistance,
             copyDetails.size);
    }

    //--------------------------------------------------------------------
    public Locus(
            Gene branch,
            int    maxLeafDistance,
            int    rootDistance,
            int    size)
    {
        this.branch          = branch;
        this.maxLeafDistance = maxLeafDistance;
        this.rootDistance    = rootDistance;
        this.size            = size;
    }


    //--------------------------------------------------------------------
    public Gene gene()
    {
        return branch;
    }

    public int lociNestingDepth()
    {
        return maxLeafDistance;
    }

    public int rootDistance()
    {
        return rootDistance;
    }

    public int size()
    {
        return size;
    }
}
