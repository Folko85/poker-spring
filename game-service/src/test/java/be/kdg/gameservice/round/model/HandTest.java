package be.kdg.gameservice.round.model;

import be.kdg.gameservice.card.Card;
import be.kdg.gameservice.card.CardType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public final class HandTest {
    @Test
    public void testCardRankSort() {
        Hand hand = new Hand();
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(CardType.JACK_OF_CLUBS));
        cards.add(new Card(CardType.ACE_OF_DIAMONDS));
        cards.add(new Card(CardType.ACE_OF_HEARTS));
        cards.add(new Card(CardType.JACK_OF_DIAMONDS));
        cards.add(new Card(CardType.JACK_OF_HEARTS));
        hand.setCards(cards);

        hand.generateCardRanks();
    }
}