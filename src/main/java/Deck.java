import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private List<PlayingCard> cards;

    public Deck(int size) {
        switch (size) {
            case 36:
                this.create36CardsDeck();
                break;
            case 52:
                this.create52CardsDeck();
                break;
            default:
                throw new IllegalArgumentException("Invalid deck size. Enter 36 or 52 cards");
        }
    }

    public List<PlayingCard> getAllCards() {
        return cards;
    }

    public PlayingCard getCard() {
        PlayingCard card = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return card;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }

    private void create52CardsDeck() {
        cards = new ArrayList<>();
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            for (PlayingCard.Rank rank : PlayingCard.Rank.values()) {
                cards.add(new PlayingCard(rank, suit));
            }
        }
    }

    private void create36CardsDeck() {
        cards = new ArrayList<>();
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            PlayingCard.Rank[] ranks = PlayingCard.Rank.values();
            for (int i = 4; i < ranks.length; i++) {
                cards.add(new PlayingCard(ranks[i], suit));
            }
        }
    }
}
