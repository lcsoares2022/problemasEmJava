package entities;

import exceptions.DomainException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private Integer roomNumber;
    private LocalDate checkin;
    private LocalDate checkout;

    public Reservation() {
    }

    public Reservation(Integer roomNumber, String checkin, String checkout) throws DomainException {
        LocalDate checkinDate = LocalDate.parse(checkin, fmt);
        LocalDate checkoutDate = LocalDate.parse(checkout, fmt);

        setCheckinIsAfterException(checkinDate, checkoutDate);

        this.roomNumber = roomNumber;
        this.checkin = checkinDate;
        this.checkout = checkoutDate;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }


    public Integer duration() {
        Period difDias = Period.between(this.checkin, this.checkout);
        Integer dias = difDias.getDays();
        return dias;
    }

    public void updateDates(String check_in, String check_out) throws DomainException {
        LocalDate checkinDate = LocalDate.parse(check_in, fmt);
        LocalDate checkoutDate = LocalDate.parse(check_out, fmt);

        if (!checkinDate.isAfter(LocalDate.now()))
            throw new DomainException("Reservation dates for update must be future dates");

        setCheckinIsAfterException(checkin, checkout);

        this.checkin = checkinDate;
        this.checkout = checkoutDate;
    }

    public void setCheckinIsAfterException(LocalDate checkinDate, LocalDate checkoutDate) {
        if (checkinDate.isAfter(checkoutDate))
            throw new DomainException("Check-out date must be after check-in date");
    }



    @Override
    public String toString() {
        return  "Reservation: "
                + "Room "
                + this.getRoomNumber()
                + ", "
                + "check-in: "
                + this.checkin.format(fmt)
                + ", check-out: "
                + this.checkout.format(fmt)
                + ", "
                + this.duration()
                + " nights";
    }



}
