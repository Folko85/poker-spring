package be.kdg.gameservice.card;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public final class CardTypeTest {
    private List<CardType> cards;

    @BeforeEach
    public void setup() {
        this.cards = new ArrayList<>(Arrays.asList(CardType.values()));
    }

    @Test
    public void cardRank() {
        for (Rank rank : Rank.values()) {
            assertEquals(4, cards.stream().filter(c -> c.getRank().equals(rank)).count());
        }
    }

    @Test
    public void cardSuit() {
        for (Suit suit : Suit.values()) {
            assertEquals(13, cards.stream().filter(c -> c.getSuit().equals(suit)).count());
        }
    }

    @Test
    public void cardEvaluation() {
        for (int i = 1; i <= 52; i++) {
            final int eval = i;
            assertEquals(1, cards.stream().filter(c -> c.getEvaluation() == eval).count());
        }
    }
}
