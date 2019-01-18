package ao.ai.evo.coding.invoke;

import com.google.inject.cglib.reflect.FastClass;
import com.google.inject.cglib.reflect.FastMethod;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 *
 */
public class MethodMessage extends AbstractMessage
{
    //--------------------------------------------------------------------
    private final FastMethod deleget;


    //--------------------------------------------------------------------
    public MethodMessage(FastClass clazz, Method toInvoke)
    {
        super(toInvoke.getParameterTypes());

        deleget = clazz.getMethod( toInvoke ); 
//        deleget = toInvoke;
    }


    //--------------------------------------------------------------------
    public boolean isStatic()
    {
        return Modifier.isStatic(deleget.getModifiers());
    }


    //--------------------------------------------------------------------
    public Object dispatch(Object receiver, Object... args)
    {
        try
        {
            return deleget.invoke(receiver, args);
        }
        catch (Exception e)
        {
            throw new Error(
                    deleget.toString() + " :: " +
                        String.valueOf(receiver) + " :: " +
                        Arrays.toString(args),
                    e);
        }
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return deleget.getName();
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MethodMessage that = (MethodMessage) o;
        return deleget.equals(that.deleget);
    }

    @Override
    public int hashCode()
    {
        return deleget.hashCode();
    }
}
