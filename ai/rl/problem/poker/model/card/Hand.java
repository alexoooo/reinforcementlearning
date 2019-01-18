package ao.ai.rl.problem.poker.model.card;

import ao.ai.evo.coding.diversity.Combiner;

import java.util.Arrays;

/**
 * Immutable.
 */
public class Hand implements Comparable<Hand>
{
    //--------------------------------------------------------------------
    private final Card[] POCKET;
    private final Card[] COMMUNITY;
    private final int    VALUE; //1 is the best, and 7462 is worst


    //--------------------------------------------------------------------
    public Hand(Card... sevenCards)
    {
        this(sevenCards[0], sevenCards[1],
             new Card[]{sevenCards[2], sevenCards[3], sevenCards[4],
                        sevenCards[5], sevenCards[6]});
    }
    public Hand(Card pocketA, Card pocketB, Card... community)
    {
        assert pocketA != null;
        assert pocketB != null;
        assert community.length == 5;

        POCKET    = new Card[]{ pocketA, pocketB };
        COMMUNITY = community.clone();
        VALUE     = bestFiveValue();
    }


    //--------------------------------------------------------------------
    private int bestFiveValue()
    {
        Combiner<Card> permuter =
                new Combiner<Card>(new Card[]{
                        POCKET[0], POCKET[1],
                        COMMUNITY[0], COMMUNITY[1], COMMUNITY[2],
                        COMMUNITY[3], COMMUNITY[4]}, 5);

        int    bestFiveValue = Integer.MAX_VALUE;
        while (permuter.hasMoreElements())
        {
            Card permutation[] = permuter.nextElement();

            int permutationRank = Card.handRank(permutation);
            if (permutationRank < bestFiveValue)
            {
                bestFiveValue = permutationRank;
            }
        }

        return bestFiveValue;
    }


    //--------------------------------------------------------------------
    public int compareTo(Hand o)
    {
        return Integer.signum(o.VALUE - VALUE);
    }


    //--------------------------------------------------------------------
    @Override
    public String toString()
    {
        return "pocket: " + Arrays.toString(POCKET) +
               ", community: " + Arrays.toString(COMMUNITY);
    }


    //--------------------------------------------------------------------
    public enum HandRank
    {
        HIGH_CARD,
        ONE_PAIR,
        TWO_PAIR,
        THREE_OF_A_KIND,
        STRAIGHT,
        FLUSH,
        FULL_HOUSE,
        FOUR_OF_A_KIND,
        STRAIGHT_FLUSH;

        public static HandRank fromValue(int val)
        {
            if (val > 6185) return HIGH_CARD;        // 1277 high card
            if (val > 3325) return ONE_PAIR;         // 2860 one pair
            if (val > 2467) return TWO_PAIR;         //  858 two pair
            if (val > 1609) return THREE_OF_A_KIND;  //  858 three-kind
            if (val > 1599) return STRAIGHT;         //   10 straights
            if (val > 322)  return FLUSH;            // 1277 flushes
            if (val > 166)  return FULL_HOUSE;       //  156 full house
            if (val > 10)   return FOUR_OF_A_KIND;   //  156 four-kind
            return STRAIGHT_FLUSH;                   //   10 straight-flushes
        }
    }
}
