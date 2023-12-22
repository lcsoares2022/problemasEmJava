package models.services;

import models.entities.Contract;
import models.entities.Quote;

import java.time.LocalDate;
import java.util.List;

public class ContractService {
    private TaxService taxService;

    public ContractService(TaxService taxService) {
        this.taxService = taxService;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    public void processContract(Contract contract, Integer qtdContract) {
        List<Double> valueQuotes = getTaxService().tax(contract.getTotalValue(), qtdContract);
        LocalDate portionDate = contract.getDate().plusMonths(1);

        for (Double valueQuote : valueQuotes) {
            contract.addQuotes(new Quote(portionDate, valueQuote));
            portionDate = portionDate.plusMonths(1);
        }
    }
}
