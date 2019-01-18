package ao.ai.rl.problem.poker.model.community;

import ao.ai.rl.problem.poker.model.card.Card;
import ao.ai.rl.problem.poker.model.community.Flop;

/**
 *
 */
public class Turn extends Flop
{
    //--------------------------------------------------------------------
    private final Card FORTH;


    //--------------------------------------------------------------------
    public Turn(Card first, Card second, Card third, Card forth)
    {
        super(first, second, third);
        assert forth != null;

        FORTH = forth;
    }


    //--------------------------------------------------------------------
    public Card forth()
    {
        return FORTH;
    }
}
