package be.kdg.gameservice.room.service;

import be.kdg.gameservice.UtilTesting;
import be.kdg.gameservice.room.exception.RoomException;
import be.kdg.gameservice.room.model.PrivateRoom;
import be.kdg.gameservice.room.persistence.RoomRepository;
import be.kdg.gameservice.room.service.api.PrivateRoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class PrivateRoomServiceImplTest extends UtilTesting {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private PrivateRoomService privateRoomService;

    @BeforeEach
    public void setUp() {
        this.provideTestDataPrivateRooms(roomRepository);
    }

    @Test
    public void getPrivateRooms() {
        assertEquals(2, privateRoomService.getPrivateRooms(this.testableUserId).size());
    }

    @Test
    public void getPrivateRoom() throws RoomException {
        PrivateRoom privateRoom = privateRoomService.getPrivateRoom(this.testablePrivateRoomId, this.testableUserId);
        assertEquals(0, privateRoom.getPlayersInRoom().size());
        assertEquals(1, privateRoom.getWhiteListedUsers().size());
        assertEquals(1200, privateRoom.getGameRules().getStartingChips());
        assertEquals(12, privateRoom.getGameRules().getSmallBlind());
        assertEquals(24, privateRoom.getGameRules().getBigBlind());
        assertEquals(6, privateRoom.getGameRules().getMaxPlayerCount());
        assertEquals(15, privateRoom.getGameRules().getPlayDelay());
    }
}