import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int soma;
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos valores vai ter cada vetor? ");
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];

        System.out.println("Digite os valores do vetor A:");
        for(int i = 0; i<A.length; i++) {
            A[i] = sc.nextInt();
        }
        
        System.out.println("Digite os valores do vetor B");
        for(int i = 0; i<B.length; i++) {
            B[i] = sc.nextInt();
        }

        System.out.println("VETOR RESULTANTE:   ");
        for(int i = 0; i<C.length; i++) {
            soma = A[i] + B[i];
            C[i] = soma;
            System.out.println(C[i]);
        }

        sc.close();
    }
}
