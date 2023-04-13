package application;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class Program {
    public static void main(String[] args) throws URISyntaxException {

        ClassLoader classLoader = Program.class.getClassLoader();
        Path path = Path.of(classLoader.getResource("application/Program.class")
                .toURI())
                .getParent()
                .getParent()
                .getParent()
                .getParent()
                .getParent()
                .resolve("src/file/in.csv");
        System.out.println(path);

    }
}
