import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos numeros voce vai digitar? ");
        int N = sc.nextInt();
        int[] vect = new int[N];
        int qtdPares=0;
        for(int i = 0; i<vect.length; i++) {
            System.out.print("Digite um numero: ");
            vect[i] = sc.nextInt();
        }
        System.out.println("NUMEROS PARES:");
        for(int j = 0; j<vect.length; j++) {
            if(vect[j]%2==0) {
              System.out.print(vect[j] + " ");
              qtdPares++;  
            }      
        }
        
        System.out.println("\nQUANTIDADE DE PARES = " + qtdPares);

        sc.close();
    }
}
