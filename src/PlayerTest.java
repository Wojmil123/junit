import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    Player player;

    @BeforeEach
    void setUp(){
        player = new Player("Wojmil_123", 1999, true);
    }

    @Test
    void testCreatePlayer(){
        assertAll(
                ()-> assertEquals("Wojmil_123", player.getName()),
                ()-> assertEquals(1999, player.getBornYear()),
                ()-> assertTrue(player.getAgree())
        );
    }


}
