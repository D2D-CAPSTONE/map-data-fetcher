import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GradleWrapperDownloader {

    public static void main(String[] args) throws Exception {
        Path projectDir = Paths.get(System.getProperty("user.dir"));
        String wrapperVersion = "8.12.1";
        String jarUrl = "https://raw.githubusercontent.com/gradle/gradle/v"
                + wrapperVersion + "/gradle/wrapper/gradle-wrapper.jar";

        Path target = projectDir.resolve("gradle/wrapper/gradle-wrapper.jar");
        Files.createDirectories(target.getParent());

        try (InputStream inputStream = new URL(jarUrl).openStream();
             OutputStream outputStream = Files.newOutputStream(target)) {
            inputStream.transferTo(outputStream);
        } catch (IOException exception) {
            throw new IOException("Failed to download Gradle wrapper jar from " + jarUrl, exception);
        }
    }
}
