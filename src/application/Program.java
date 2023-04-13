package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws URISyntaxException {

        Scanner sc = new Scanner(System.in);
        ClassLoader classLoader = Program.class.getClassLoader();
        Path path = Path.of(classLoader.getResource("application/Program.class")
                .toURI())
                .getParent()
                .getParent()
                .getParent()
                .getParent()
                .getParent()
                .resolve("src/file/in.csv");

        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        try (BufferedReader bf = new BufferedReader(new FileReader(path.toFile()))){

            List<String> lines = bf.lines().toList();
        } catch (IOException e) {
            System.out.println("ERROR! " + e.getMessage());;
        }

    }
}
