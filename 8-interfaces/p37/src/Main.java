import entities.Car;
import entities.Location;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String modelCar = sc.nextLine();

        System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
        String retirada = sc.nextLine();

        System.out.print("Return (dd/MM/yyyy hh:ss): ");
        String retorno = sc.nextLine();

        System.out.print("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();

        System.out.print("Enter price per day: ");
        double pricePerDay = sc.nextDouble();

        Car car = new Car(modelCar, pricePerHour, pricePerDay);

        try {
            Location location = new Location(car, retirada, retorno);
            System.out.println(location);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            sc.close();
        }

    }
}
