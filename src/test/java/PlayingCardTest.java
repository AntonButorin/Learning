import org.junit.Assert;
import org.junit.Test;

public class PlayingCardTest {

    @Test(expected = IllegalArgumentException.class)
    public void checkCreateCardWithoutParams() {
        new PlayingCard();
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCreateCardWithNullSuit() {
        new PlayingCard(PlayingCard.Rank.ACE, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkCreateCardWithNullRank() {
        new PlayingCard(null, PlayingCard.Suit.HEARTS);
    }

    @Test
    public void checkEqualValueObjects() {
        Assert.assertEquals(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS),
                new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS));
    }

    @Test
    public void checkEqualWithObject() {
        Assert.assertNotEquals(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS), new Object());
    }

    @Test
    public void checkEqualWithNull() {
        Assert.assertNotEquals(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS), null);
    }

    @Test
    public void checkGetRank() {
        Assert.assertEquals(PlayingCard.Rank.ACE,
                new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS).getRank());
    }

    @Test
    public void checkGetSuit() {
        Assert.assertEquals(PlayingCard.Suit.HEARTS,
                new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS).getSuit());
    }

    @Test
    public void checkPlayingCardToString() {
        Assert.assertEquals("{ACE,HEARTS}",
                new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS).toString());
    }

    @Test
    public void checkHashCode() {
        Assert.assertEquals(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS).hashCode(),
                new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.HEARTS).hashCode());
    }

    @Test
    public void checkCompareSuitsOfTwoCards() {
        Assert.assertEquals(3, new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.SPADES)
                .compareTo(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.CLUBS)));
    }

    @Test
    public void checkCompareRanksOfTwoCards() {
        Assert.assertEquals(-4, new PlayingCard(PlayingCard.Rank.TEN, PlayingCard.Suit.DIAMONDS)
                .compareTo(new PlayingCard(PlayingCard.Rank.ACE, PlayingCard.Suit.DIAMONDS)));
    }

    @Test
    public void checkCompareTwoSameCards() {
        Assert.assertEquals(0, new PlayingCard(PlayingCard.Rank.TEN, PlayingCard.Suit.DIAMONDS)
                .compareTo(new PlayingCard(PlayingCard.Rank.TEN, PlayingCard.Suit.DIAMONDS)));
    }
}
