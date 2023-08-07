import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N, soma=0, qtdPares=0;
        System.out.print("Quantos elementos vai ter o vetor? ");
        N = sc.nextInt();
        int[] vect = new int[N];

        for(int i = 0; i < vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextInt();

            if(vect[i] % 2 == 0) {
                soma += vect[i];
                qtdPares++;
            }
        }
        System.out.println(soma != 0 ? "MEDIA DOS PARES = " + (double) soma / qtdPares : "NENHUM NUMERO PAR");
        sc.close();
    }
}
