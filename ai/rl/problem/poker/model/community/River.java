package ao.ai.rl.problem.poker.model.community;

import ao.ai.rl.problem.poker.model.card.Card;
import ao.ai.rl.problem.poker.model.community.Turn;

/**
 *
 */
public class River extends Turn
{
    //--------------------------------------------------------------------
    private final Card FIFTH;


    //--------------------------------------------------------------------
    public River(Card first, Card second, Card third,
                 Card forth, Card fifth)
    {
        super(first, second, third, forth);
        assert fifth != null;

        FIFTH = fifth;
    }


    //--------------------------------------------------------------------
    public Card fifth()
    {
        return FIFTH;
    }
}
