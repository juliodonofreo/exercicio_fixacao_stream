package application;

import entities.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
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

            List<Employee> employees = new ArrayList<>();
            List<String> lines = bf.lines().toList();

            for(String line: lines) {
                String[] fields = line.split(",");
                Employee employee = new Employee(fields[0], fields[1], Double.parseDouble(fields[2]));
                employees.add(employee);
            }
            List<String> moreThanSalaryEmails = employees
                    .stream()
                    .filter(x -> x.getSalary() > salary)
                    .map(Employee::getEmail)
                    .sorted()
                    .toList();

            moreThanSalaryEmails.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("ERROR! " + e.getMessage());;
        }

    }
}
