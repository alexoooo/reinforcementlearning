package ao.ai.rl.problem.snakes.axiom;

import ao.ai.axiom.Num;
import ao.ai.axiom.Bool;
import ao.ai.rl.gp.op.Exclude;
import ao.ai.rl.gp.op.Include;
import ao.ai.evo.product.Product;
import ao.util.rand.Rand;


/**
 * Vector from one Coord to another.
 * A good implementation is at...
 *  http://spacewar.googlecode.com/svn/trunk/src/edu/ou/utils/Vector2D.java
 */
public class Vec implements Comparable<Vec>
{
    //--------------------------------------------------------------------
    private static final Vec ZERO = new Vec(Num.zero(), Num.zero());

    private static final Vec NORTH =
            new Vec(Num.zero(), Num.one());

    private static final Vec SOUTH =
            new Vec(Num.zero(), Num.one().negate());

    private static final Vec EAST =
            new Vec(Num.one(), Num.zero());

    private static final Vec WEST =
            new Vec(Num.one().negate(), Num.zero());


    //--------------------------------------------------------------------
    public static Vec zero()  { return ZERO; }
    public static Vec north() { return NORTH; }
//    public static Vec south() { return SOUTH; }
    public static Vec east()  { return EAST;  }
//    public static Vec west()  { return WEST;  }

    @Exclude public static Vec fromAngle(Num angle, Num magnitude)
    {
        return new Vec(angle.cosine().times(magnitude),
                       angle.sine().times(magnitude));
    }

    @Exclude public static Vec random()
    {
        Num max = Num.one();// maxMagnitude.square();

        Num x2 = max.times( Num.random() );
        Num y2 = max.minus( x2 ).times( Num.random() );

        Num x = Rand.nextBoolean() ? x2.squareRoot()
                                   : x2.squareRoot().negate();
        Num y = Rand.nextBoolean() ? y2.squareRoot()
                                   : y2.squareRoot().negate();

//        assert(! (maxMagnitude - Math.hypot(x, y) < -0.01));
        return new Vec(x, y);
    }


    //--------------------------------------------------------------------
    private final Num x;
    private final Num y;
    private final Num magnitude;


    //--------------------------------------------------------------------
    public Vec(Num x, Num y)
    {
        assert x != null &&
               y != null;

        this.x = x;
        this.y = y;
        this.magnitude = x.hypotenuse(y);
    }


    //--------------------------------------------------------------------
    public Num x()
    {
        return x;
    }
    public Num y()
    {
        return y;
    }
    public Num magnitude()
    {
        return magnitude;
    }
    public Num angle() // in radians
    {
        return y.theta( x );
    }

    @Include public Vec unit()
    {
        return magnitude.equals( Num.zero() )
                ? EAST
                : divide( magnitude );
    }
    
    @Exclude public Vec intron(Product<Vec> intron)
    {
        return Vec.zero();
    }


    //--------------------------------------------------------------------
    public Num angleBetween(Vec v)
    {
        Num num = x.times(v.x).plus( y.times(v.y) );
        Num den = magnitude.times( v.magnitude );

        if(den.equals( Num.zero() )) return Num.zero();

        if (num.absoluteValue().compareTo( den.absoluteValue() ) > 0)
        {
            num = num.compareTo(den) > 0 ? den : den.negate();
        }

        Num angle = num.divide( den ).inverseCosine();
        return cross(v).compareTo(Num.zero()) >= 0
               ? angle : angle.negate();
    }

    
    //--------------------------------------------------------------------
    public Vec plus(Vec addend)
    {
        return new Vec(x.plus( addend.x ),
                       y.plus( addend.y ));
    }
    @Include public Vec negate()
    {
        return new Vec(x.negate(), y.negate());
    }
    public Vec minus(Vec vec)
    {
        return new Vec(x.minus( vec.x ),
                       y.minus( vec.y ));
    }


    //--------------------------------------------------------------------
    public Vec times(Num factor)
    {
        return new Vec(x.times( factor ),
                       y.times( factor ));
    }
    public Vec divide(Num factor)
    {
        return new Vec(x.divide( factor ),
                       y.divide( factor ));
    }

    
    //--------------------------------------------------------------------
    @Include public Num dot(Vec with)
    {
        return x.times( with.x ).plus( y.times(with.y) );
    }
    @Include public Num cross(Vec with)
    {
        return x.times( with.y ).minus( y.times(with.x) );
    }

    
    //--------------------------------------------------------------------
    @Include public Vec rotate(Num angle)
    {
        Num cos = angle.cosine();
        Num sin = angle.sine();
        return new Vec(x.times(cos).minus( y.times(sin) ),
                       x.times(sin).plus(  y.times(cos) ));
    }

    @Include public Vec project(Vec onto)
    {
        return times( dot(onto).divide(dot(this)) );
    }


    //--------------------------------------------------------------------
//    public Comparison compare(Vec with)
//    {
//        return new Comparison(compareTo(with));
//    }
    public Bool lessThan(Vec that)
    {
        return Bool.valueOf(compareTo(that) < 0);
    }
    public Bool lessThanOrEqualTo(Vec that)
    {
        return Bool.valueOf(compareTo(that) <= 0);
    }
    public Bool equalsTo(Vec that)
    {
        return Bool.valueOf(compareTo(that) == 0);
    }
    public Bool greaterThanOrEuqalTo(Vec that)
    {
        return Bool.valueOf(compareTo(that) >= 0);
    }
    public Bool greaterThan(Vec that)
    {
        return Bool.valueOf(compareTo(that) > 0);
    }

    @Exclude public int compareTo(Vec o)
    {
        return magnitude.compareTo(o.magnitude);
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return x + " " + y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || !(o instanceof Vec)) return false;

        Vec vec = (Vec) o;
        return magnitude.equals(vec.magnitude) &&
               x.equals(vec.x) &&
               y.equals(vec.y);
    }
    
    @Override
    public int hashCode()
    {
        int result;
        result = x.hashCode();
        result = 31 * result + y.hashCode();
        result = 31 * result + magnitude.hashCode();
        return result;
    }
}
