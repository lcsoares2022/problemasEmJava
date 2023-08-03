import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        int N, a, b, div;
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        
        for (int i = 0; i<N; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            if(b != 0) 
                System.out.println(div=a/b);
            else 
                System.out.println("divisao impossivel");
        }
        scanner.close();
    }
}
                
            


