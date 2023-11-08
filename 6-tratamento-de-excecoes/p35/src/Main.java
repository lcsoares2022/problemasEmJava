import model.entities.Reservation;
import model.exceptions.DomainException;
import model.utils.InputScannerUtil;
import model.utils.ReservationInput;

public class Main {

    public static void main(String[] args) {
        try {
            Reservation reservation = new Reservation(ReservationInput.inputRoom(), ReservationInput.inputCheckin(),
                    ReservationInput.inputCheckout());
            System.out.println(reservation);

            System.out.println("\nEnter data to update the reservation: ");
            reservation.updateDates(ReservationInput.inputCheckin(), ReservationInput.inputCheckout());
            System.out.println(reservation);

        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }
        finally {
            InputScannerUtil.getClose();
        }

    }


}