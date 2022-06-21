package be.kdg.gameservice.room.service;

import be.kdg.gameservice.UtilTesting;
import be.kdg.gameservice.room.exception.RoomException;
import be.kdg.gameservice.room.model.Room;
import be.kdg.gameservice.room.persistence.RoomRepository;
import be.kdg.gameservice.room.service.api.RoomService;
import be.kdg.gameservice.round.exception.RoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
@Transactional
public class RoomServiceImplTest extends UtilTesting {
    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomRepository roomRepository;

    @BeforeEach
    public void setup() {
        provideTestDataRooms(roomRepository);
    }

    @Test
    public void getRooms() {
        assertEquals(3, roomService.getRooms(Room.class).size());
    }

    @Test()
    public void startNewRoundFail() throws RoomException, RoundException {
        roomService.getCurrentRound(testableRoomIdWithoutPlayers);
        fail("A round should not be started with less than 2 players inside one room.");
    }
}
