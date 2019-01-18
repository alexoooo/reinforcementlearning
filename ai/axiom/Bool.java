package ao.ai.axiom;

import ao.ai.evo.product.Product;
import ao.ai.rl.gp.op.BooleanCondition;
import ao.ai.rl.gp.op.Exclude;
import ao.ai.rl.gp.op.Include;

/**
 * true/false
 */
public enum Bool implements BooleanCondition
{
    //--------------------------------------------------------------------
    TRUE(true), FALSE(false);


    //--------------------------------------------------------------------
    public static Bool trueVal()  { return TRUE;  }
    public static Bool falseVal() { return FALSE; }

    public static Bool valueOf( boolean value )
    {
        return (value) ? TRUE : FALSE;
    }


    //--------------------------------------------------------------------
    private final boolean val;


    //--------------------------------------------------------------------
    private Bool(boolean value)
    {
        val = value;
    }


    //--------------------------------------------------------------------
    @Exclude public boolean isTrue()
    {
        return val;
    }


    //--------------------------------------------------------------------
    @Exclude public Bool and(Product<Bool> x)
    {
        return valueOf(val && x.build().val);
    }
    @Exclude public Bool or(Product<Bool> x)
    {
        return valueOf(val || x.build().val);
    }
    @Exclude public Bool not()
    {
        return valueOf(!val);
    }
    @Exclude public Bool xor(Bool x)
    {
        return valueOf(val ^ x.val);
    }
    @Exclude public Bool xnor(Bool x)
    {
        return valueOf(val == x.val);
    }
    @Exclude public Bool implies(Product<Bool> x)
    {
        return valueOf(!val || x.build().val);
    }
    @Include public Bool nand(Product<Bool> x)
    {
        return valueOf(!(val && x.build().val));
    }
    @Exclude public Bool nor(Product<Bool> x)
    {
        return valueOf(!(val || x.build().val));
    }
    @Exclude public Bool majority(Bool x, Product<Bool> y)
    {
        int trueCount = (  val ? 1 : 0) +
                        (x.val ? 1 : 0);
        if (trueCount == 2) return Bool.TRUE;
        if (trueCount == 0) return Bool.FALSE;
        return y.build();
    }


    //--------------------------------------------------------------------
    @Include public <T> T ternary(Product<T> ifTrue, Product<T> ifFalse)
    {
        return val ? ifTrue.build() : ifFalse.build();
    }

    @Exclude public Bool intron(Product<Bool> intron)
    {
        return Bool.falseVal();
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return String.valueOf(val);
    }
}
