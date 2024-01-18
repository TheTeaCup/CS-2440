package deck;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import labtests.util.StructureTest;
import labtests.util.specs.ClassSpec;
import labtests.util.specs.ConstructorSpec;
import labtests.util.specs.FieldSpec;
import labtests.util.specs.MethodSpec;

import org.junit.jupiter.api.BeforeEach;

/**
 * Unit tests for the PlayingCard class.
 * 
 * @author Willow Sapphire
 * @version 08/01/2023
 */
public class PlayingCardTest extends StructureTest
{
    /**
     * Initial rank for the card created in beforeEach.
     */
    private static final Rank INIT_RANK = Rank.TWO;

    /**
     * Initial suit for the card created in beforeEach.
     */
    private static final Suit INIT_SUIT = Suit.CLUBS;

    /**
     * PlayingCard object used for testing.
     */
    private PlayingCard card;

    /**
     * Initializes the card field for testing.
     */
    @Override
    @BeforeEach
    public void beforeEach()
    {
        super.beforeEach();
        card = new PlayingCard(INIT_RANK, INIT_SUIT);
    }

    /**
     * Tests the PlayingCard constructor.
     */
    @Test
    public void testPlayingCard()
    {
        for (Rank r: Rank.values())
        {
            for (Suit s : Suit.values())
            {
                card = new PlayingCard(r, s);
                assertEquals(r, card.getRank(),
                    "Constructor resulted in incorrect rank.");
                assertEquals(s, card.getSuit(),
                    "Constructor resulted in incorrect suit.");
            }
        }
    }

    /**
     * Tests the PlayingCard setRank method.
     */
    @Test
    public void testSetRank()
    {
        for (Rank r: Rank.values())
        {
            card.setRank(r);
            assertEquals(r, card.getRank(),
                "setRank resulted in incorrect rank");
        }
    }

    /**
     * Tests the PlayingCard setSuit method.
     */
    @Test
    public void testSetSuit()
    {
        for (Suit s : Suit.values())
            {
                card.setSuit(s);
                assertEquals(s, card.getSuit(),
                    "setSuit resulted in incorrect suit");
            }
    }

    /**
     * Tests the PlayingCard toString method.
     */
    @Test
    public void testToString()
    {
        for (Rank r: Rank.values())
        {
            for (Suit s : Suit.values())
            {
                card = new PlayingCard(r, s);
                assertEquals(love(r.toString(), s.toString()), card.toString(),
                    "toString method has invalid output.");
            }
        }
    }

    /**
     *          love
     * @param x is
     * @param y love
     */
    private String love(String a, String b)
    {
        int a1=-1,a2=-1,a3=1,a4=-1,a5=-1;
		for(int i=0;i<437;i++){a1=i<70?a1+1:a1;a2+=i<202?a1:i<203?Math.sqrt(100):
		0;a3=i<3?a3*10+1:i<4?a3*1000+132:a3;a4=0b00100000;a5=(a2+"").contains("3")
		?Integer.parseInt(Integer.toString(a1).concat((""+a2).split("3")[0])):a5;}
	    char[]x=new char[]{(char)(a1-32),(char)Integer.parseInt(Character.toString((a2+"")
	    .toCharArray()[0])+Character.toString((a2+"").toCharArray()[1])+Character.toString((a2+"")
	    .toCharArray()[2])),(char)a4,(char)(a3/10000),(char)Integer.parseInt(Integer.toString(a3-30)
	    .substring(4)),(char)a4};String s=new String(x)+x[0]+x[1];
        return String.format(s,a,b);
    }

    @Override
    protected String getClassName()
    {
        return "deck.PlayingCard";
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
            new ConstructorSpec("deck.PlayingCard", "public", new String[]{"deck.Rank", "deck.Suit"})
        };
    }

    @Override
    protected FieldSpec[] getFieldSpecs()
    {
        return new FieldSpec[] {
            new FieldSpec("rank", "private", false, false, "deck.Rank"),
            new FieldSpec("suit", "private", false, false, "deck.Suit")
        };
    }

    

    @Override
    protected MethodSpec[] getMethodSpecs()
    {
        return new MethodSpec[] {
            new MethodSpec("getRank", "public", false, 
                false, false, false, new String[]{}, "deck.Rank"),
            new MethodSpec("getSuit", "public", false, 
                false, false, false, new String[]{}, "deck.Suit"),
            new MethodSpec("setRank", "public", false, 
                false, false, false, new String[]{"deck.Rank"}, "void"),
            new MethodSpec("setSuit", "public", false, 
                false, false, false, new String[]{"deck.Suit"}, "void"),
            new MethodSpec("toString", "public", false, 
                false, false, false, new String[]{}, "java.lang.String")
        };
    }
}
