import java.util.Locale;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        double renda, IR=0, valorDeTaxa1, valorDeTaxa2, valorDeTaxa3;
        renda = scanner.nextDouble();
        if (renda <= 2000.00) {
            System.out.println("Isento");
        } else if (renda <= 3000.00) {
            valorDeTaxa1 = renda - 2000.00;
            IR = valorDeTaxa1 * 0.08;
        } else if (renda <= 4500.00) {
            valorDeTaxa2 = renda - 3000.00;
            IR = 999.99 * 0.08 + valorDeTaxa2 * 0.18;
        } else {
            valorDeTaxa3 = renda - 4500.00;
            IR = 999.99 * 0.08 + 1499.99 * 0.18 + valorDeTaxa3 * 0.28;
        }
        scanner.close();
        if(renda>2000.00)
            System.out.printf("R$ %.2f\n", IR);
    }
}
