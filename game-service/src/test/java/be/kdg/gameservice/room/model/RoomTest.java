package be.kdg.gameservice.room.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public final class RoomTest {
    @Test
    public void roomCreation() {
        Room room = new Room(new GameRules(8, 16, 25, 2500, 5, 1, 50), "Test room");
        assertEquals(room.getGameRules().getStartingChips(), 2500);
        assertEquals(room.getGameRules().getMaxPlayerCount(), 5);
        assertEquals(room.getGameRules().getPlayDelay(), 25);
        assertEquals(room.getGameRules().getSmallBlind(), 8);
        assertEquals(room.getGameRules().getBigBlind(), 16);
        assertEquals(room.getGameRules().getMinLevel(), 1);
        assertEquals(room.getGameRules().getMaxLevel(), 50);
        assertEquals(room.getRounds().size(), 0);
        assertEquals(room.getPlayersInRoom().size(), 0);
    }
}