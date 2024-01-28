import entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            Set<Employee> employees = new HashSet<>();

            while(line != null) {
                String[] dataEmplo = line.split(",");
                Employee employee = new Employee(dataEmplo[0],dataEmplo[1], Double.parseDouble(dataEmplo[2]));
                employees.add(employee);
                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            double value = sc.nextDouble();

            System.out.println("Email of people whose salary is more than 2000.00: ");

            employees.stream()
                    .filter(x -> x.getSalary() > value)
                    .sorted((x,y) -> x.getEmail().compareTo(y.getEmail().toUpperCase()))
                    .forEach(x -> System.out.println(x.getEmail()));

            double sum =
                    employees.stream()
                            .filter(x -> x.getName().charAt(0) == 'M')
                            .mapToDouble(Employee::getSalary)
                            .sum();

            System.out.print("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));


        } catch (IOException e) {
            System.out.println("Processing error: " + e.getMessage());
        }










        sc.close();
    }
}