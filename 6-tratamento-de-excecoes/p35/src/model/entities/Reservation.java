package model.entities;

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

    public Reservation(Integer roomNumber, String checkin, String checkout) throws Exception {
        excecption();
        this.roomNumber = roomNumber;
        this.checkin = LocalDate.parse(checkin, fmt);
        this.checkout = LocalDate.parse(checkout,fmt);
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

    public void updateDates(String check_in, String check_out) throws Exception {
        LocalDate checkin = LocalDate.parse(check_in, fmt);
        LocalDate checkout = LocalDate.parse(check_out, fmt);

        excecption();

        this.checkin = checkin;
        this.checkout = checkout;
    }


    public void excecption() throws Exception {

        if(!checkin.isAfter(LocalDate.now()))
            throw new Exception("Reservation dates for update must be future dates");

        if(checkin.isAfter(checkout))
            throw new Exception("Check-out date must be after check-in date");
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
