import model.entities.Reservation;

import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        System.out.print("Room number: ");
        Integer room = sc.nextInt();
        sc.nextLine();

        try {
            Reservation reservation = new Reservation(room, inputCheckin(), inputCheckout());
            System.out.println(reservation);

            System.out.println("\nEnter data to update the reservation: ");
            reservation.updateDates(inputCheckin(), inputCheckout());
            System.out.println(reservation);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    public static String inputCheckin() {
        System.out.print("Check-in date (dd/MM/yyyy): ");
        String checkin = sc.nextLine();
        return checkin;
    }

    public static String inputCheckout() {
        System.out.print("Check-out date (dd/MM/yyyy): ");
        String checkout = sc.nextLine();
        return checkout;
    }

}