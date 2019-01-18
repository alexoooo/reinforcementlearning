package ao.ai.axiom;

import ao.ai.evo.product.Product;
import ao.ai.rl.gp.op.Exclude;
import ao.ai.rl.gp.op.Include;
import ao.util.rand.Rand;

/**
 * A protected number.
 * Infinity and NaN are both turned to 0.
 */
@Exclude
public class Num implements Comparable<Num>
{
    //--------------------------------------------------------------------
    private static final Num ZERO = new Num(0);
    private static final Num ONE  = new Num(1);
    private static final Num TWO  = new Num(2);
    private static final Num E    = new Num(Math.E);

    private static final Num PI            = new Num(Math.PI);
    private static final Num TWO_PI        = new Num(2.0 * Math.PI);
    private static final Num HALF_PI       = new Num(0.5 * Math.PI);
    private static final Num THREE_HALF_PI = new Num(1.5 * Math.PI);


    //--------------------------------------------------------------------
    @Include public static Num zero() { return ZERO; }
    @Include public static Num one()  { return ONE;  }
    @Exclude public static Num two()  { return TWO;  }
    @Include public static Num e()    { return E;    }

    @Include public static Num pi()          { return PI;            }
    @Exclude public static Num twoPi()       { return TWO_PI;        }
    @Exclude public static Num halfPi()      { return HALF_PI;       }
    @Exclude public static Num threeHalfPi() { return THREE_HALF_PI; }
    
    @Exclude public static Num random()
    {
        return new Num(Rand.nextDouble());
    }


    //--------------------------------------------------------------------
    private final double val;


    //--------------------------------------------------------------------
    public Num(double value)
    {
        val = (Double.isInfinite(value) || Double.isNaN(value))
              ? 0 : value;
    }


    //--------------------------------------------------------------------
    @Exclude public double value()
    {
        return val;
    }


    //--------------------------------------------------------------------
    @Exclude public Num absoluteValue()
    {
        return new Num(Math.abs(val));
    }

    @Include public Num intron(Product<Num> intron)
    {
        return Num.zero();
    }
    

    //--------------------------------------------------------------------
    @Include public Num plus(Num addend)
    {
        return new Num(val + addend.val);
    }
    @Include public Num negate()
    {
        return new Num(-val);
    }
    @Exclude public Num minus(Num substractor)
    {
        return new Num(val - substractor.val);
    }
    @Include public Num times(Num multiplier)
    {
        return new Num(val * multiplier.val);
    }
    @Include public Num reciprocal()
    {
        return new Num(1.0 / val);
    }
    @Exclude public Num divide(Num denominator)
    {
        return new Num(val / denominator.val);
    }
    @Include public Num remainder(Num denominator)
    {
        return new Num(val % denominator.val);
    }

    @Exclude public Num squareRoot()
    {
        return new Num(Math.sqrt(val));
    }
    @Exclude public Num square()
    {
        return new Num(val * val);
    }
    @Exclude public Num hypotenuse(Num with)
    {
        return new Num(Math.hypot(val, with.val));
    }

    @Include public Num exp()
    {
        return new Num(Math.exp(val));
    }
    @Include public Num ln()
    {
        return val == 0
                ? zero() : new Num(Math.log(Math.abs(val)));
    }
    @Include public Num absLnRoot()
    {
        return new Num(Math.pow(Math.abs(val), 1.0/Math.E));
    }
//    @Include public Num pow(Num that)
//    {
//        return new Num(Math.pow(val, that.val));
//    }

    
    //--------------------------------------------------------------------
    @Include public Num sine()
    {
        return new Num(Math.sin(val));
    }
    @Include public Num cosine()
    {
        return new Num(Math.cos(val));
    }

    @Include public Num inverseSine()
    {
        return new Num(Math.asin(val));
    }
    @Include public Num inverseCosine()
    {
        return new Num(Math.acos(val));
    }
    @Exclude public Num inverseTangent()
    {
        return new Num(Math.atan(val));
    }
    @Exclude public Num theta(Num with)
    {
        return new Num(Math.atan2(val, with.val));
    }


    //--------------------------------------------------------------------
//    @Include public Num max(Num with)
//    {
//        return compareTo(with) > 0
//                ? this : with;
//    }
//    @Include public Num min(Num with)
//    {
//        return compareTo(with) < 0
//                ? this : with;
//    }
//    @Include public Num midpoint(Num with)
//    {
//        return new Num((val + with.val)/2.0);
//    }


    //--------------------------------------------------------------------
//    public Comparison compare(Num that)
//    {
//        return new Comparison(compareTo(that));
//    }

//    public Bool lessThan(Num that)
//    {
//        return Bool.valueOf(compareTo(that) < 0);
//    }
//    public Bool lessThanOrEqualTo(Num that)
//    {
//        return Bool.valueOf(compareTo(that) <= 0);
//    }
//    public Bool equalsTo(Num that)
//    {
//        return Bool.valueOf(compareTo(that) == 0);
//    }
//    public Bool greaterThanOrEuqalTo(Num that)
//    {
//        return Bool.valueOf(compareTo(that) >= 0);
//    }
//    public Bool greaterThan(Num that)
//    {
//        return Bool.valueOf(compareTo(that) > 0);
//    }
//
    @Include public Comparison compare()
    {
        return new Comparison(
                val < 0
                ? -1
                : (val > 0)
                   ? 1 : 0);
    }

    @Exclude public int compareTo(Num that)
    {
        return Double.compare(val, that.val);
    }

    
    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return String.valueOf( val );
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || !(o instanceof Num)) return false;

        Num num = (Num) o;
        return Double.compare(val, num.val) == 0;
    }

    @Override
    public int hashCode()
    {
        long temp = val != +0.0d ? Double.doubleToLongBits(val) : 0L;
        return (int)(temp ^ (temp >>> 32));
    }
}
