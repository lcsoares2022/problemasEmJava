import entities.Fisica;
import entities.Juridica;
import entities.Pessoa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.print("Enter the number of tax payers: ");
        int numPayers = sc.nextInt();

        Pessoa[] pessoas = new Pessoa[numPayers];

        for (int i = 0; i < numPayers; i++) {
            System.out.println("Tax payer #" + (i+1) + " data:");
            System.out.print("Individual or company (i/c)? ");
            char select = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();
            if(select == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                pessoas[i] = new Fisica(name,anualIncome,healthExpenditures);
            } else if(select == 'c') {
                System.out.print("Number of employees: ");
                int numEmployees = sc.nextInt();
                pessoas[i] = new Juridica(name, anualIncome, numEmployees);
            } else
                throw new IllegalArgumentException("Dado inválido: Só é possível Individual ou company (i/c)");
        }

        Double total = 0.0;
        System.out.println("\nTAXES PAID: ");
        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa.toString());
            total += pessoa.getValorImposto();
        }

        System.out.printf("\nTOTAL TAXES: $ %.2f", total);

        sc.close();
    }
}