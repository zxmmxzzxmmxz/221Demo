import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import
public class GameWorldTest {
    public static final String PLAYER_NAME = "ximin";
    public GameWorld game;

    @BeforeEach
    void beofre(){
        game = new GameWorld();
    }

    @Test
    void testCreateCharacterRandomPosition() {
        game.createCharacterRandomPosition(PLAYER_NAME);

        assert game.player.getName().equals(PLAYER_NAME);
        assert game.getRoom(game.player.getX(), game.player.getY()).getC().getName().equals(PLAYER_NAME);

        Room r = new Room(1,1,"a");

    }
}
