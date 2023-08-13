import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int M,N, X;
        boolean marcador = false;
        

        M = sc.nextInt();
        N = sc.nextInt();
        int[][] mat = new int[M][N];

        for(int i = 0; i < mat.length; i++) {

            for(int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        X = sc.nextInt();

        for(int i = 0; i < mat.length; i++) {

            for(int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == X) {
                    marcador = true;
                    System.out.println("Position " + i + "," + j);
                    
                    System.out.print(j - 1 >= 0 
                    ? "Left: " + mat[i][j-1]
                    : " ");
                    
                    System.out.print(j + 1 < mat[i].length 
                    ? "\nRight: " + mat[i][j+1]
                    : " ");
                    
                    System.out.print(i - 1 >= 0
                    ? "\nUp: " + mat[i-1][j]
                    : " ");
                    
                    System.out.print(i + 1 < mat.length
                    ? "\nDown: " + mat[i+1][j]
                    : " ");

                    System.out.println(" ");                    
                } 
            }
        }
        
        if(marcador == false) {
            System.out.println("Não existe o elemento no array bidimensional");
        }
        
        sc.close();
    }
}
