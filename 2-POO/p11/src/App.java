import java.util.Locale;
import java.util.Scanner;
import classes.CurrencyConverter;

public class App {
    public static void main(String[] args) throws Exception {
        double priceDolar, qtdDolar;
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the dollar price? ");
        priceDolar = sc.nextDouble();
        System.out.print("How many dollars will be bought? ");
        qtdDolar = sc.nextDouble();
        System.out.printf("Amount to be paid in reais = %.2f",CurrencyConverter.comprarDolar(priceDolar, qtdDolar));
        sc.close();
    }
}
