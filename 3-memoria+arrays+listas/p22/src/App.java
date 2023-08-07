import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N, posicaoMaior=0;
        System.out.print("Quantas pessoas voce vai digitar? ");
        N = sc.nextInt();
        sc.nextLine();
        int[] idades = new int[N];
        String[] nomes = new String[N];

        System.out.println("Dados da 1a pessoa:");
        System.out.print("Nome: ");
        nomes[0] = sc.nextLine();
        System.out.print("idade: ");
        idades[0] = sc.nextInt();
        for(int i = 1; i<N; i++) {
            sc.nextLine();
            System.out.print("Dados da " + (i+1) + "a pessoa\n" );
            System.out.print("Nome: ");
            nomes[i] = sc.nextLine();
            System.out.print("idade: ");
            idades[i] = sc.nextInt();
            if(idades[posicaoMaior] < idades[i]) {
                posicaoMaior = i;
            }
        }
        System.out.println("PESSOA MAIS VELHA: " + nomes[posicaoMaior]);
        sc.close();
    }
}
