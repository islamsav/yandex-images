import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class TestUtils {

    public static String getFilePath(String fileName) {
        String resPath = String.format("images/%s", fileName);
        URL res = ClassLoader.getSystemClassLoader().getResource(resPath);
        File file = null;
        try {
            file = Paths.get(res.toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (file == null) {
            throw new AssertionError(String.format("Файл с именем [%s] не найден в папке images в ресурсах", fileName));
        }
        return file.getAbsolutePath();
    }
}
