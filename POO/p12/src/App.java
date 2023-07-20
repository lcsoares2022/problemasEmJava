import java.util.Locale;
import java.util.Scanner;
import entities.Conta;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number: ");
        int numConta = sc.nextInt();
        sc.nextLine(); //consumo de quebra 
        System.out.print("Enter account holder: ");
        String name = sc.nextLine();
        System.out.print("Is there an initial deposit (y/n)? ");
        char option = sc.next().charAt(0);
        Conta conta;
        double deposit;
        if (option == 'y') {
            System.out.print("Enter initial deposit value: ");
            deposit = sc.nextDouble();
            conta = new Conta(numConta, name, deposit);
        } else {
            conta = new Conta(numConta, name);
        }

        System.out.print("\nAccount data:\n");
        System.out.println(conta);

        System.out.print("\nEnter a deposit value:");
        deposit = sc.nextDouble();
        conta.depositar(deposit);

        System.out.println("Updated account data: ");
        System.out.println(conta);

        System.out.print("\nEnter a withdraw value:");
        double sacar = sc.nextDouble();
        conta.sacar(sacar);

        System.out.println("Updated account data: ");
        System.out.println(conta);
   
                
        sc.close();


    }
}
