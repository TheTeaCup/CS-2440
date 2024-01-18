package deck;

import labtests.util.EnumTest;

/**
 * Unit tests for the Rank enum.
 * 
 * @author Willow Sapphire
 * @version 08/01/2023
 */
public class RankTest extends EnumTest
{
    /**
     * Constructs a new enumerated type test for the Suit enum.
     */
    public RankTest()
    {
        super("deck.Rank", "public",
            new String[]{"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN",
                "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"});
    }
}
