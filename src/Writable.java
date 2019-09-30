import java.io.FileNotFoundException;

public interface Writable {
    void write(String FileName) throws FileNotFoundException;
}
