import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int index=0;
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos numeros voce vai digitar? ");
        int N = sc.nextInt();
        double[] vect = new double[N];
        System.out.print("Digite um numero: ");
        vect[0] = sc.nextDouble();
        double aux = vect[0];
        for(int i = 1; i<vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextDouble();
            if(vect[i] > aux) {
                aux = vect[i];
                index = i;
            }
        }
        System.out.println("MAIOR VALOR = " + aux + "\nPOSICAO DO MAIOR VALOR = " + index);

        sc.close();

    }
}
