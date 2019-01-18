package ao.ai.rl.problem.poker.model.card.lookup;

/**
 * see
 *  http://www.suffecool.net/poker/code/arrays.h
 *  http://www.geocities.com/psenzee/code/fast_eval.c
 */
public class Lookup
{
    //--------------------------------------------------------------------
    private Lookup() {}


    //--------------------------------------------------------------------
    public static int unique5(int index)
    {
        return Unique5.at( index );
    }

    
    //--------------------------------------------------------------------
    public static int flushes(int index)
    {
        return Flushes.at( index );
    }

    //--------------------------------------------------------------------
    public static int remainingHands(int primeProduct)
    {
        return HashValues.at( find_fast(primeProduct) );
    }
    private static int find_fast(int u)
    {
        long adjusted = u;
        adjusted = (adjusted + 0xe91aaa35) & 0xFFFFFFFFL;

        adjusted ^= adjusted >> 16;

        adjusted += ((adjusted << 8) & 0xFFFFFFFFL);
        adjusted &= 0xFFFFFFFFL;

        adjusted ^= adjusted >> 4;

        long b  = (adjusted >> 8) & 0x1ff;
        long a  = (((adjusted + ((adjusted << 2) & 0xFFFFFFFFL)) & 0xFFFFFFFFL) >> 19);
        return (int)(a ^ HashAdjust.at((int)b));
    }
}
