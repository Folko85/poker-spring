package be.kdg.gameservice.room.model;

import be.kdg.gameservice.round.model.ActType;
import be.kdg.gameservice.round.model.HandType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public final class PlayerTest {
    private Player player;

    @BeforeEach
    public void setup() {
        this.player = new Player(2500, "1", 1);
    }

    @Test
    public void createPlayer() {
        assertEquals(player.getChipCount(), 2500);
        assertEquals(player.getHandType(), HandType.BAD);
        assertEquals(player.getLastAct(), ActType.UNDECIDED);
        assertEquals(player.getUserId(), "1");
        assertEquals(player.getSeatNumber(), 1);
        assertTrue(player.isInRoom());
        assertFalse(player.isInRound());
    }

    @Test
    public void resetPlayer() {
        player.setInRound(false);
        player.setHandType(HandType.STRAIGHT_FLUSH);
        player.setLastAct(ActType.RAISE);

        player.resetPlayer();

        assertEquals(HandType.BAD, player.getHandType());
        assertEquals(ActType.UNDECIDED, player.getLastAct());
        assertTrue(player.isInRound());
    }

}