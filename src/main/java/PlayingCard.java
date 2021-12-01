public class PlayingCard implements Comparable<PlayingCard> {

    public enum Suit {
          CLUBS, DIAMONDS, HEARTS, SPADES
    }

    public enum Rank {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    private final Rank rank;
    private final Suit suit;

    public PlayingCard() {
        throw new IllegalArgumentException("Invalid parameters");
    }

    public PlayingCard(Rank rank, Suit suit) {
        if (rank != null && suit != null) {
            this.rank = rank;
            this.suit = suit;
        } else {
            throw new IllegalArgumentException("Invalid parameters");
        }
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(PlayingCard o) {
        int result = this.suit.compareTo(o.suit);
        if (result == 0) {
            result = this.rank.compareTo(o.rank);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        PlayingCard pc = (PlayingCard) o;
        return this.rank == pc.rank && this.suit == pc.suit;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + rank.hashCode();
        result = prime * result + suit.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "{" + rank + "," + suit + "}";
    }
}
