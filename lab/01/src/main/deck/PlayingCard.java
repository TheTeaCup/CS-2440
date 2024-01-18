package deck;

public class PlayingCard {
    private Suit suit;
    private Rank rank;

    public PlayingCard(Rank rank, Suit suit) {
        this.suit = suit;
        this.rank = rank;
    }

    public Rank getRank() {
        return this.rank;
    }

    public Suit getSuit() {
        return this.suit;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public String toString() {
        return this.rank + " of " + this.suit;
    }
}