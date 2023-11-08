import model.entities.Reservation;
import model.exceptions.DomainException;
import model.utils.InputScannerUtil;
import model.utils.ReservationInput;

public class Main {

    public static void main(String[] args) {
        try {
            Reservation reservation = new Reservation(ReservationInput.inputRoom(), ReservationInput.inputCheckin(),
                    ReservationInput.inputCheckout()); //lança exceção
            System.out.println(reservation);

            System.out.println("\nEnter data to update the reservation: ");
            reservation.updateDates(ReservationInput.inputCheckin(), ReservationInput.inputCheckout()); //lança exceção
            System.out.println(reservation);

        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
            //todo: aqui pode corrigir com data mais próxima
        } catch (RuntimeException e) {
            System.out.println("Unexpected error!");
        }
        finally {
            InputScannerUtil.getClose();
        }

    }


}