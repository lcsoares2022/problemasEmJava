package models.services;

import java.util.ArrayList;
import java.util.List;

public class PaypalService implements TaxService{


    private static final Double JURO_SIMPLES = 0.01;

    private static final Double TAX_PAYMENT = 0.02;

    public List<Double> tax(Double amount, Integer portions) {
        List<Double> quotes = new ArrayList<>();

        double portionValue = amount / portions;
        double simpleInterestAplication, portionsAplication, partialResult,
                taxPaymentAplication, finalResult;

        for(int i = 1; i <= portions; i++) {
            simpleInterestAplication = portionValue * JURO_SIMPLES;
            portionsAplication = simpleInterestAplication * i;
            partialResult = portionValue + portionsAplication;

            taxPaymentAplication = partialResult * TAX_PAYMENT;
            finalResult = partialResult + taxPaymentAplication;
            quotes.add(finalResult);
        }

        return quotes;
    }


}
