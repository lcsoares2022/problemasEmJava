import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int N, fatorial;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        fatorial = 1;
        for(int i = fatorial+1; i<=N; i++)
              fatorial *= i;
        scanner.close();
        System.out.println(fatorial);
    }
}
