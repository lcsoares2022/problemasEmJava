import java.util.Locale;
import java.util.Scanner;

import entities.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        int N, id;
        String name;
        double salary;
        
        System.out.print("How many employees will be registered?");
        N = sc.nextInt();
        Funcionario[] funcionarios = new Funcionario[N];
        

        for(int i = 1; i <= N; i++){
            sc.nextLine();
            System.out.print("\nEmplyoee #" + i + ":");
            System.out.print("\nId: ");
            id = sc.nextInt();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Salary: ");
            salary = sc.nextDouble();
            funcionarios[i] = new Funcionario(id, name, salary);

        }

    }
}
