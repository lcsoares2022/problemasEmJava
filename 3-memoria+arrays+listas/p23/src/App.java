import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        double media;
        int N;
        System.out.print("Quantos alunos serao digitados? ");
        N = sc.nextInt();
        
        String[] nomes = new String[N];
        double[] notasSemestre1 = new double[N];
        double[] notasSemestre2 = new double[N];
        
        for(int i = 0; i<N; i++) {
            sc.nextLine();
            System.out.println("Digite nome, primeira e segunda nota do " + (i+1) + "o aluno:");
            nomes[i] = sc.nextLine();
            notasSemestre1[i] = sc.nextDouble();
            notasSemestre2[i] = sc.nextDouble();
        }

        System.out.println("Alunos aprovados:");
        for(int i = 0; i<N; i++) {
            media = (notasSemestre1[i] + notasSemestre2[i]) / 2.0;
            if(media >= 6.0)
                System.out.println(nomes[i]);
        }
        sc.close();       
    }
}
