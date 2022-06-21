package be.kdg.gameservice.round.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public final class DeckTest {
    @Test
    public void cardCount() {
        assertEquals(52, new Deck().getNumberOfCards());
    }
}
