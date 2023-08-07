import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        double soma=0.0, media;
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos numeros voce vai digitar: ");
        int N = sc.nextInt();
        double[] vect = new double[N];
    
        for (int i = 0; i<vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextDouble();   
            soma += vect[i];     
        }
        media = soma / vect.length;
        System.out.print("VALORES = ");
        for (int i = 0; i<vect.length; i++) {
            System.out.print(" " + vect[i]);
        }
        System.out.printf("\nSOMA = %.2f\nMEDIA = %.2f",soma,media);
    }
}
