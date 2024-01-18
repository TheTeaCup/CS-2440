package deck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

/**
 * Unit tests for the Deck class.
 * 
 * @author Willow Sapphire
 * @version 04/06/2023
 */
public class DeckTest extends StructureTest
{
    /**
     * The number of cards that should be in the deck.
     */
    private int numCards = 52;

    /**
     * The seed for the random number generator.
     */
    private int seed = 12414543;
    
    /**
     * The deck object used for testing.
     */
    private Deck deck;

    /**
     * Initializes the deck field for testing.
     */
    @Override
    @BeforeEach
    public void beforeEach()
    {
        super.beforeEach();
        deck = new Deck(seed);
    }

    /**
     * Tests the deck's one-arg constructor.
     */
    @Test
    public void testOneArgConstructor()
    {
        deck = new Deck();
        testInitialCardOrder(deck);
    }

    /**
     * Tests the deck's no-arg constructor.
     */
    @Test
    public void testNoArgConstructor()
    {
        deck = new Deck();
        testInitialCardOrder(deck);
    }

    /**
     * Tests the deck's shuffle method.
     * The average number of cards that are in new places
     * after shuffling should not be less than lowerAvgBound.
     */
    @Test
    public void testShuffle()
    {
        int lowerAvgBound = 48;
        Deck deck2 = new Deck(seed);
        deck.shuffleDeck();
        deck2.shuffleDeck();
        // Test that shuffling with the same seed are consistent.
        for (int i = 0; i < numCards; i++)
        {
            assertEquals(deck2.getCard(i).getRank(),
                deck.getCard(i).getRank(),
                "Suffle method is not consistent when given the same seed\n"
                    + "Did you make sure to set the seed in the one-arg constructor?");
            assertEquals(deck2.getCard(i).getSuit(),
                deck.getCard(i).getSuit(),
                "Suffle method is not consistent when given the same seed\n"
                    + "Did you make sure to set the seed in the one-arg constructor?");
        }
        // tests that shuffles are random
        int numTrials = 1000000;
        int minDiff = Integer.MAX_VALUE;
        int maxDiff = Integer.MIN_VALUE;
        long totalDiff = 0;
        Deck a = new Deck();
        Deck b;
        for (int i = 0; i < numTrials; i++) {
            b = new Deck();
            b.shuffleDeck();
            int diff = numDifPosition(a, b);
            if (diff < minDiff) minDiff = diff;
            if (diff > maxDiff) maxDiff = diff;
            totalDiff += diff;
            a = b;
        }
        int avgDiff = (int) (totalDiff / numTrials);
        assertTrue(avgDiff >= lowerAvgBound);
    }

    /**
     * Tests the output of toString.
     */
    @Test
    public void testToString()
    {
        String errorMessage = "Deck toString has incorrect output.";
        assertEquals(x(deck), deck.toString(), errorMessage);
        deck.shuffleDeck();
        assertEquals(x(deck), deck.toString(), errorMessage);
        deck.shuffleDeck();
        assertEquals(x(deck), deck.toString(), errorMessage);
    }

    /**
     * Helper method to test the initial order of cards.
     * 
     * @param deck the deck to test
     */
    private void testInitialCardOrder(Deck deck)
    {
        int deckIndex = 0;
        PlayingCard card;
        for (Rank rank : Rank.values())
        {
            for (Suit suit : Suit.values())
            {
                card = deck.getCard(deckIndex++);
                assertEquals(card.getRank(), rank,
                    String.format("Rank of card at index %d incorrect\n"
                        + "Could be an issue in a constructor or getRank.",
                        deckIndex));
                assertEquals(card.getSuit(), suit,
                    String.format("Suit of card at index %d incorrect\n"
                        + "Could be an issue in a constructor or getSuit.",
                        deckIndex));
            }
        }
    }

    /**
     * Helper method that calculates how many cards
     * are in different positions between two decks.
     * 
     * @param a the first deck
     * @param b the second deck
     * @return the number of cards in different positions between the decks.
     */
    private int numDifPosition(Deck a, Deck b)
    {
        int diffPosition = 0;
        for (int i = 0; i < 52; i++)
        {
            PlayingCard ai = a.getCard(i);
            PlayingCard bi = b.getCard(i);
            if (ai.getRank() != bi.getRank() || ai.getSuit() != bi.getSuit())
            {
                diffPosition++;
            }
        }
        return diffPosition;
    }

    /**
     * ???????
     * @param d ????????
     * @return ???????
     */
    private String x(Deck d)
    {
        for(String x="x\u1203%s of %s\n\u1203";;x="x"+x+String.format
        (x.split("\u1203")[1],d.getCard(x.split("\u1203")[0].length()-1)
        .getRank(),d.getCard(x.split("\u1203")[0].length()-1).getSuit()))
        if(x.split("\u1203")[0].length()==53)return x.substring(64,x.length()-1);
    }

    @Override
    protected String getClassName()
    {
        return "deck.Deck";
    }

    @Override
    protected ClassSpec getClassSpec()
    {
        return new ClassSpec(getClassName(), "public", 
            false, false, false);
    }
    
    @Override
    protected ConstructorSpec[] getConstructorSpecs()
    {
        return new ConstructorSpec[] {
            new ConstructorSpec("deck.Deck", "public", new String[]{}),
            new ConstructorSpec("deck.Deck", "public", new String[]{"int"})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[] {
            new FieldSpec("NUM_CARDS", "public", true, true, "int"),
            new FieldSpec("generator",             "private", false, false, "java.util.Random"),
            new FieldSpec("deck", "private", false, false, "java.util.ArrayList")
        };
    }
   
    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[] {
            new MethodSpec("initialize", "public", false, 
                false, false, false, new String[]{}, "void"),
            new MethodSpec("shuffleDeck", "public", false, 
                false, false, false, new String[]{}, "void"),
            new MethodSpec("getCard", "public", false, 
                false, false, false, new String[]{"int"}, "deck.PlayingCard"),
            new MethodSpec("toString", "public", false, 
                false, false, false, new String[]{}, "java.lang.String")
        };
    }
}
