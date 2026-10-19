package arrayapp.reader;

import arrayapp.exception.ArrayDataException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TextFileReader {

    public List<String> readLines(String filePath) throws ArrayDataException {
        try {
            Path path = Path.of(filePath);
            return Files.readAllLines(path);
        } catch (IOException exception) {
            String message = "Failed to read file: " + filePath;
            throw new ArrayDataException(message, exception);
        }
    }
}
