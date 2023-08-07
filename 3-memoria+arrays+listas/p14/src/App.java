import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos números voce vai digitar? ");
        int N = sc.nextInt();
        int[] vect = new int[N];
        for(int i = 0; i<vect.length; i++) {
            System.out.print("Digite um número: ");
            vect[i] = sc.nextInt();
        }
        System.out.println("NUMEROS NEGATIVOS:"); 
        for(int i = 0; i<vect.length; i++) {
               if(vect[i] < 0) 
                System.out.println(vect[i]);                
        }
    }
}
