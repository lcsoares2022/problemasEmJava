import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Funcionario;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        int N;
        String name;
        double salary;
        
        System.out.print("How many employees will be registered? ");
        N = sc.nextInt();
        

        for(int i = 0; i < N; i++){
            System.out.print("\nEmplyoee #" + (i+1) + ":");
            System.out.print("\nId: ");
            int id = sc.nextInt();
            while(hasId(listaFuncionarios, i)) {
                System.out.println("id informado já existe! Favor, digite um id válido");
                id = sc.nextInt();
            }
            sc.nextLine();
            System.out.print("Name: ");
            name = sc.nextLine();
            System.out.print("Salary: ");
            salary = sc.nextDouble();
            Funcionario func = new Funcionario(id, name, salary);
            listaFuncionarios.add(i, func);
       }

        System.out.print("\nEnter the employee id that will have salary increase: ");
        int id = sc.nextInt();
        Funcionario funcEncontrado = listaFuncionarios.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        if(funcEncontrado != null) {
            System.out.print("Enter the percentage: ");
            double percentagem = sc.nextDouble();
            funcEncontrado.aumentarSalario(percentagem);
        } else 
            System.out.println("id informado não existe!");

        System.out.println("\nList of employees:");
        
        for (Funcionario funcionario : listaFuncionarios) {
            System.out.println(funcionario);
        }
        System.out.println("\n");

        sc.close();
    }

    public static boolean hasId(List<Funcionario> listaFuncionarios, int id) {
        boolean idJaExiste = listaFuncionarios.stream().anyMatch(func -> func.getId() == id);
        return idJaExiste;
    }
}
        
// A lista facilita encontrar o funcionário pelo id.


        
