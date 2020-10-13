import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface IFileCheck {
    public void verifyFileExists();

    public BufferedReader getBufferedReader() throws FileNotFoundException;
    
    public void close() throws IOException;
}
