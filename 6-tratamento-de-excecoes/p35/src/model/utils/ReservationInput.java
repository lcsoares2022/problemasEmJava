package model.utils;

public class ReservationInput {
    public static String inputCheckin() {
        System.out.print("Check-in date (dd/MM/yyyy): ");
        String checkin =  InputScannerUtil.sc.nextLine();
        return checkin;
    }

    public static String inputCheckout() {
        System.out.print("Check-out date (dd/MM/yyyy): ");
        String checkout =  InputScannerUtil.sc.nextLine();
        return checkout;
    }

    public static Integer inputRoom() {
        System.out.print("Room number: ");
        Integer room = InputScannerUtil.sc.nextInt();
        InputScannerUtil.sc.nextLine();
        return room;
    }

}
