package models.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {

    private Integer numContract;
    private LocalDate date;

    private Double totalValue;

    private List<Quote> quotes;


    public Contract() {
    }

    public Contract(Integer numContract, LocalDate date, Double totalValue) {
        this.numContract = numContract;
        this.date = date;
        this.totalValue = totalValue;
        this.quotes = new ArrayList<>();
    }

    public Integer getNumContract() {
        return numContract;
    }

    public void setNumContract(Integer numContract) {
        this.numContract = numContract;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }

    public void addQuotes(Quote quote) {
        this.quotes.add(quote);
    }
}
