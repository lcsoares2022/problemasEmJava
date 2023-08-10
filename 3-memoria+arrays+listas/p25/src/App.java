import java.util.Scanner;
import entities.Student;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        Student[] quartos = new Student[10];
        

        System.out.print("How many rooms will be rented? ");
        int N = sc.nextInt();

        if(N>=1 && N<=10) 
            for(int j = 0; j<N; j++) {
                sc.nextLine();
                System.out.println("Rent #" + (j+1));
                System.out.print("Name: ");
                String name = sc.nextLine(); //Variável temporária
                System.out.print("Email: ");
                String email = sc.next();
                System.out.print("Room: ");
                int i = sc.nextInt();
                System.out.print("\n");
                
                if(quartos[i] == null) quartos[i] = new Student(name,email);
                else System.out.println("Quarto ocupado!");
            }
         else 
            System.out.println("O número de pessoas é inválido: só podem de 1 a 10 pessoas. ");
        
        System.out.println("Busy room:");
        for(int i = 0; i<quartos.length; i++) 
            if(quartos[i] != null) 
                System.out.println(i + ": " + quartos[i].getName() + ", " + quartos[i].getEmail());
                
        
        sc.close();
    }
}
