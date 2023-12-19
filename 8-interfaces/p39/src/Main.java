import models.entities.CarRental;
import models.entities.Invoice;
import models.entities.Vehicle;
import models.services.BrazilTaxService;
import models.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String modelCar = sc.nextLine();

        System.out.print("Pickup (dd/MM/yyyy hh:ss): ");
        LocalDateTime retirada = LocalDateTime.parse(sc.nextLine(), fmt);

        System.out.print("Return (dd/MM/yyyy hh:ss): ");
        LocalDateTime retorno = LocalDateTime.parse(sc.nextLine(), fmt);

        CarRental carRental = new CarRental(retirada, retorno, new Vehicle(modelCar));

        System.out.print("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();

        System.out.print("Enter price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour, pricePerDay, new BrazilTaxService());

        rentalService.processInvoice(carRental);

        System.out.println("INVOICE: ");
        System.out.println("Basic Payment: " + String.format("%.2f",carRental.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f",carRental.getInvoice().getTax()));
        System.out.println("Total Payment: " + String.format("%.2f",carRental.getInvoice().getTotalPayment()));

        sc.close();

    }
}