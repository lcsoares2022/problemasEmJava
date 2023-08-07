import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        double media, soma=0.0;
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos elementos vai ter o vetor? ");
        int N = sc.nextInt();
        double[] vect = new double[N];

        for(int i = 0; i<vect.length; i++) {
            System.out.print("Digite um número: ");
            vect[i] = sc.nextDouble();
            soma += vect[i];
        }
        media = soma / N;
        System.out.printf("\nMEDIA DO VETOR = %.3f",media);
        System.out.println("\nELEMENTOS ABAIXO DA MÉDIA:");
        for(int i = 0; i<vect.length; i++) {
            if(vect[i] < media)
                System.out.println(vect[i]);
        }
        
        sc.close();


    }
}
