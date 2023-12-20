package models.services;

import java.util.List;

public interface TaxService {
    List<Double> tax(Double amount, Integer parcela);
}
