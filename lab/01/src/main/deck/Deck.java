package deck;
import java.util.Random;
import java.util.ArrayList;

public class Deck
{
    public static final int NUM_CARDS = 52;
    private Random generator;
    private ArrayList<PlayingCard> deck;

    public Deck() {
        generator = new Random();
        initialize();
    }

    public Deck(int seed) {
        generator = new Random(seed);
        initialize();
    }

    public void initialize() {
        deck = new ArrayList<PlayingCard>();
        
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                deck.add(new PlayingCard(rank, suit));
            }
        }
    }

    public void shuffleDeck() {
        for (int i = 1; i < NUM_CARDS; i++) {
            int index = generator.nextInt(NUM_CARDS);
            PlayingCard temp = deck.get(i);
            deck.set(i, deck.get(index));
            deck.set(index, temp);
        }
    }

    public PlayingCard getCard(int index) {
        return deck.get(index);
    }

    public String toString() {
        String str = "";

        for (PlayingCard card : deck)
        {
            str += card.toString();
            str += "\n";
        }

        str = str.substring(0, str.length() - 1);
        return str;
    }
}