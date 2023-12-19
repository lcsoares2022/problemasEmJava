package models.services;

public class BrazilTaxService implements TaxService{

    public Double tax(Double amount) {

        return amount <= 100.00 ? amount * 0.20 : amount * 0.15;
    }
}
