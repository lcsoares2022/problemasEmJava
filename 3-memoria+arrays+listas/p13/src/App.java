import java.util.Locale;
import java.util.Scanner;
import entities.Product;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        int N;
        String name;
        double price, somaPrice=0;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        Product[] produtos = new Product[N];

        for(int i = 0; i<N; i++) {
            sc.nextLine();
            name = sc.nextLine();
            price = sc.nextDouble();
            produtos[i] = new Product(name,price);
            somaPrice += produtos[i].getPrice();
        }
        double avg = somaPrice / N;
        System.out.printf("AVERAGE PRICE = %.2f",avg);
    }
}
