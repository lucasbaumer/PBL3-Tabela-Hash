import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {
    public static String[] readNamesArray(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath)).toArray(new String[0]);
    }
}