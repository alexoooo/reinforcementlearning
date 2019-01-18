package ao.ai.rl.problem.poker.model.personal;

import ao.ai.rl.problem.poker.model.card.Card;

/**
 *
 */
public class Hole
{
    //--------------------------------------------------------------------
    private final Card FIRST;
    private final Card SECOND;


    //--------------------------------------------------------------------
    public Hole(Card first, Card second)
    {
        assert first != null &&
               second != null;

        FIRST  = first;
        SECOND = second;
    }


    //--------------------------------------------------------------------
    public Card first()
    {
        return FIRST;
    }

    public Card second()
    {
        return SECOND;
    }
}
