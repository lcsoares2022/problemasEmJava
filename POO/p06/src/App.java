import java.util.Locale;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        double l1, l2, l3, areaX, areaY, p;
        String maior;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the measures of triangle X:");
        l1 = scanner.nextDouble();
        l2 = scanner.nextDouble();
        l3 = scanner.nextDouble();
        p = (l1 + l2 + l3) / 2.0;
        areaX = Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
        System.out.println("Enter the measures of triangle Y:");
        l1 = scanner.nextDouble();
        l2 = scanner.nextDouble();
        l3 = scanner.nextDouble();
        p = (l1 + l2 + l3) / 2.0;
        areaY = Math.sqrt(p*(p-l1)*(p-l2)*(p-l3));
        System.out.printf("Triangle X area: %.4f\n",areaX);
        System.out.printf("Triangle Y area: %.4f\n",areaY);
        maior = areaX > areaY ? "Larger area: X"
                : areaX < areaY ? "Larger area: Y"
                : "area X and Y is the same";
        System.out.println(maior);
        scanner.close();

    }
}
