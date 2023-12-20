import models.entities.Contract;
import models.entities.Quote;
import models.services.ContractService;
import models.services.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados de contrato:");
        System.out.print("Numero: ");
        Integer numberContract = sc.nextInt();
        sc.nextLine();

        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate dateContract = LocalDate.parse(sc.nextLine(), fmt);

        System.out.print("Valor do contrato: ");
        Double valueContract = sc.nextDouble();

        System.out.print("Entre com o número de parcelas: ");
        Integer numQuotes = sc.nextInt();

        Contract contract = new Contract(numberContract, dateContract, valueContract);

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, numQuotes);

        List<Quote> quotes = contract.getQuotes();

        System.out.println("Parcelas:");
        quotes.forEach(x -> System.out.println(x.getDate().format(fmt) + " - " + String.format("%.2f", x.getValue())));
        sc.close();
    }
}