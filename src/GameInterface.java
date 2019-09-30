import java.io.FileNotFoundException;

public interface GameInterface extends Writable{
    String handleInput(String input);

    void load(String documentName) throws FileNotFoundException;
}
