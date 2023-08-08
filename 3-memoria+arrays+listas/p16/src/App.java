import java.util.Locale;
import java.util.Scanner;

import entities.Pessoa;

public class App {
    public static void main(String[] args) throws Exception {
        int menor16=0;
        double somaAltura=0.0,percentual16;
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantas pessoas serao digitadas? ");
        int N = sc.nextInt();
        Pessoa[] pessoas = new Pessoa[N];

        for(int i = 0; i<pessoas.length; i++) {
            sc.nextLine();
            System.out.println("Dados da " + (i+1) + "a pessoa:");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("idade: ");
            int idade = sc.nextInt();
            System.out.print("altura: ");
            double altura = sc.nextDouble();
            pessoas[i] = new Pessoa(nome, idade, altura);
            
            somaAltura += pessoas[i].getAltura(); //importante dividir cada propósito em um loop. Aqui eu cometi a má prática de colocar tudo em um mesmo loop. 
            if(pessoas[i].getIdade() < 16)
                menor16++;
        }
        percentual16 = (double) menor16/pessoas.length*100;
        System.out.printf("\nAltura média: %.2f\n",somaAltura/N);
        System.out.println("Pessoas com menos de 16 anos: " + percentual16 + "%");
        
        for(int i = 0; i<pessoas.length; i++) {
            if(pessoas[i].getIdade() < 16)
                System.out.println(pessoas[i].getName());
        }
        
        sc.close();
    }
}
