package ao.ai.rl.problem.snakes.axiom;

import ao.ai.axiom.Num;
import ao.ai.evo.product.Product;
import ao.ai.rl.gp.op.Exclude;
import ao.ai.rl.gp.op.Include;

/**
 * coordinate
 */
public class Coord
{
    //--------------------------------------------------------------------
    private static final Coord ORIGIN = new Coord(Num.zero(), Num.zero());

    //--------------------------------------------------------------------
    public static Coord origin() { return ORIGIN; }


    //--------------------------------------------------------------------
    private final Num x;
    private final Num y;


    //--------------------------------------------------------------------
    public Coord(Num x, Num y)
    {
        assert x != null &&
               y != null;

        this.x = x;
        this.y = y;
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
    public Num thera()
    {
        return y.divide( x ).inverseTangent();
    }

    @Include public Coord intron(Product<Coord> intron)
    {
        return Coord.origin();
    }


    //--------------------------------------------------------------------
    @Include public Coord plus(Coord addend)
    {
        return new Coord(x.plus( addend.x ),
                         y.plus( addend.y ));
    }
    @Include public Coord negate()
    {
        return new Coord(x.negate(), y.negate());
    }
    @Exclude public Coord minus(Coord subtractor)
    {
        return new Coord(x.minus( subtractor.x ),
                         y.minus( subtractor.y ));
    }
    @Exclude public Coord times(Num factor)
    {
        return new Coord(x.times(factor),
                         y.times(factor));
    }
    @Include public Coord times(Coord factor)
    {
        return new Coord(x.times(factor.x),
                         y.times(factor.y));
    }

    //--------------------------------------------------------------------
    public Coord translateX(Num delta)
    {
        return new Coord(x.plus( delta ), y);
    }
    public Coord translateY(Num delta)
    {
        return new Coord(x, y.plus( delta ));
    }

    @Include public Coord towardOrigin(Num delta)
    {
        Num theta  = thera();
        Num deltaX = delta.times( theta.cosine() );
        Num deltaY = delta.times( theta.sine()   );

        return new Coord(x.minus(deltaX),
                         y.minus(deltaY));
    }

    @Include public Coord rotate(Num radians)
    {
        Num hypotenuse = radians.absoluteValue();
        Num newTheta   = thera().minus(radians);
        return new Coord( hypotenuse.times( newTheta.cosine() ),
                          hypotenuse.times( newTheta.sine()   ));
    }


    //--------------------------------------------------------------------
    public Vec vectorTo(Coord coord)
    {
        return new Vec(coord.x.minus(x),
                       coord.y.minus(y));
    }

    public Coord translate(Vec vec)
    {
        return new Coord(x.plus( vec.x() ),
                         y.plus( vec.y() ));
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "x: " + x + ", y: " + y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coord coord = (Coord) o;
        return x.equals(coord.x) && y.equals(coord.y);
    }

    @Override
    public int hashCode()
    {
        int result;
        result = x.hashCode();
        result = 31 * result + y.hashCode();
        return result;
    }
}
