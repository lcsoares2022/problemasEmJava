package models.entities;

import java.time.LocalDate;

public class Quote {
    private LocalDate date;

    private Double value;

    public Quote(LocalDate date, Double value) {
        this.date = date;
        this.value = value;
    }

    public LocalDate getDate() {
        return date;
    }


    public Double getValue() {
        return value;
    }

}
