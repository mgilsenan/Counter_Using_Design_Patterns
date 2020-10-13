import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileCheck implements IFileCheck {
    private String fileName;
    private File file;
    static BufferedReader reader = null;
    private FileInputStream stream;

    public FileCheck(String fileName, File file) {
        this.fileName = fileName;
        this.file = file;
    }

    public void verifyFileExists() {
        if (!file.canRead()) {
            System.out.println("Cannot open srcFile '" + fileName + "'");

        } else {
            System.out.println("charcount: [OK] srcFilename = '" + fileName + "'");
        }
    }

    @Override
    public BufferedReader getBufferedReader() throws FileNotFoundException {
        stream = new FileInputStream(file);

        InputStreamReader input = new InputStreamReader(stream);

        reader = new BufferedReader(input);

        return reader;
    }

    @Override
    public void close() throws IOException {
        stream.close();

    }
}
