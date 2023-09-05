package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HourContract {
    private LocalDate date;
    private Double valuePerHour;
    private Integer hour;

    public HourContract(String date, Double valuePerHour, Integer hour) {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.date = LocalDate.parse(date,fmt);
        this.valuePerHour = valuePerHour;
        this.hour = hour;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(Double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Double totalValue() {
        return getHour() * getValuePerHour();
    }

}
