package models.services;

import models.entities.CarRental;
import models.entities.Invoice;

import java.time.Duration;

public class RentalService {

    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService; //atributo resultado da associação

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoice(CarRental carRental) {
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.00;

        double basicPayment;
        if(hours <= 12) {
            basicPayment = Math.ceil(hours) * getPricePerHour();
        } else {
            basicPayment = Math.ceil(hours / 24.00) * getPricePerDay();
        }
        Double tax = getBrazilTaxService().tax(carRental.getInvoice().getBasicPayment());
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public TaxService getBrazilTaxService() {
        return taxService;
    }

    public void setBrazilTaxService(TaxService taxService) {
        this.taxService = taxService;
    }
}
