import entities.Department;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter department's name: ");
        String department = sc.next();
        sc.nextLine();
        Department dpt = new Department(department);

        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String name = sc.nextLine();


        System.out.print("Level: ");
        String level = sc.next();
        WorkerLevel workerLevel = WorkerLevel.valueOf(level.toUpperCase());

        System.out.print("Base salary: ");
        Double baseSalary = sc.nextDouble();

        Worker worker = new Worker(name, workerLevel, baseSalary, dpt);

        System.out.print("How many contracts to this worker? ");
        int qtdContracts = sc.nextInt();

        for(int i = 1; i<=qtdContracts; i++) {
            System.out.println("Enter contract #" + i + " data:");
            System.out.print("Date (DD/MM/YYYY): ");
            String date = sc.nextLine();
            sc.nextLine();
            System.out.print("Value per hour: ");
            Double valuePerHour = sc.nextDouble();
            System.out.print("Duration (hours): ");
            Integer duration = sc.nextInt();
            sc.nextLine();
            HourContract hourContract = new HourContract(date,valuePerHour,duration);
            worker.addContract(hourContract);
        }

        System.out.print("\nEnter month and year to calculate income (MM/YYYY): ");
        String dateEmString = sc.nextLine();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MM/yyyy");
        LocalDate dateEmLocalDate = LocalDate.parse(dateEmString, fmt);
        Double salary = worker.income(dateEmLocalDate.getYear(),dateEmLocalDate.getMonthValue());

        System.out.println(worker);
        System.out.println("Income for " + dateEmString + ": " + salary);


        sc.close();
    }
}


