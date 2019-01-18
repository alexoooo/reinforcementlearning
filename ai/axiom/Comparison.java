package ao.ai.axiom;

/**
 *
 */
public class Comparison
{
    //--------------------------------------------------------------------
    private final int val;


    //--------------------------------------------------------------------
    public Comparison(int value)
    {
        val = Integer.signum( value );
    }
//    public Comparison(Num value)
//    {
//        val = Integer.signum( value.value() );
//    }



    //--------------------------------------------------------------------
    public Bool lessThan()
    {
        return Bool.valueOf(val < 0);
    }
//    public Bool lessThanOrEqualTo()
//    {
//        return Bool.valueOf(val <= 0);
//    }
//    public Bool equalsTo()
//    {
//        return Bool.valueOf(val == 0);
//    }
//    public Bool greaterThanOrEuqalTo()
//    {
//        return Bool.valueOf(val >= 0);
//    }
    public Bool greaterThan()
    {
        return Bool.valueOf(val > 0);
    }
}
