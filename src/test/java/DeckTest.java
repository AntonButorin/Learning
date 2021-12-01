import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DeckTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkCreateDeckWithInvalidNumberOfCards() {
        new Deck(55);
    }

    @Test
    public void checkCreateDeckWithThirtySixCards() {
        Assert.assertEquals(36, new Deck(36).getAllCards().size());
    }

    @Test
    public void checkCreateDeckWithFiftyTwoCards() {
        Assert.assertEquals(52, new Deck(52).getAllCards().size());
    }

    @Test
    public void checkGetDeck() {
        List<PlayingCard> cards = new ArrayList<>();
        for (PlayingCard.Suit suit : PlayingCard.Suit.values()) {
            PlayingCard.Rank[] ranks = PlayingCard.Rank.values();
            for (int i = 4; i < ranks.length; i++) {
                cards.add(new PlayingCard(ranks[i], suit));
            }
        }
        Assert.assertEquals(cards, new Deck(36).getAllCards());
    }

    @Test
    public void checkGetCard() {
        Assert.assertEquals(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.SPADES),
                new Deck(52).getCard());
    }

    @Test
    public void checkShuffle() {
        Deck deck = new Deck(52);
        deck.shuffle();
        Assert.assertNotEquals(deck.getAllCards(), new Deck(52).getAllCards());
    }
}
