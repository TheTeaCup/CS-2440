package deck;

import labtests.util.EnumTest;

/**
 * Unit tests for the Suit enum.
 * 
 * @author Willow Sapphire
 * @version 08/01/2023
 */
public class SuitTest extends EnumTest
{
    /**
     * Constructs a new enumerated type test for the Suit enum.
     */
    public SuitTest()
    {
        super("deck.Suit", "public",
            new String[]{"CLUBS", "DIAMONDS", "HEARTS", "SPADES"});
    }
}