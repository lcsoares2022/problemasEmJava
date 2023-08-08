import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int N, M=0,F=0, maiorAltura=0, menorAltura=0;
        double somaAlturasFemininas=0.0;
        System.out.print("Quantas pessoas serao digitadas? ");
        N = sc.nextInt();

        char[] generos = new char[N];
        double[] alturas = new double[N];

        for(int i = 0; i<N; i++) {
            System.out.print("Altura da " + (i+1) + "a pessoa: ");
            alturas[i] = sc.nextDouble();
            sc.nextLine();
            System.out.print("Genero da " + (i+1) + "a pessoa: ");
            generos[i] = sc.next().charAt(0);
            
            if(alturas[i] > alturas[maiorAltura])
                maiorAltura = i;
            else if (alturas[i] < alturas[menorAltura]) 
                menorAltura = i;

            if(generos[i] == 'M'){
                M++;
            } else {
                somaAlturasFemininas += alturas[i];
                F++;
            }

        }
        double media = somaAlturasFemininas / F;
        
        System.out.printf("\nMenor altura = %.2f\nMaior altura = %.2f\nMedia das alturas das mulheres = %.2f\nNumero de homens = %d",alturas[menorAltura],alturas[maiorAltura],media,M);

    }
}
