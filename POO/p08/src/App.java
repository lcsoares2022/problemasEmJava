import java.util.Locale;
import java.util.Scanner;
import classes.Triangle;

public class App {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
        Triangle x, y;
        x = new Triangle();
        y = new Triangle();
		System.out.println("Enter the measures of triangle X: ");
		x.l1 = sc.nextDouble();
		x.l2 = sc.nextDouble();
		x.l3 = sc.nextDouble();
		System.out.println("Enter the measures of triangle Y: ");
		y.l1 = sc.nextDouble();
		y.l2 = sc.nextDouble();
		y.l3 = sc.nextDouble();
		System.out.printf("Triangle X area: %.4f%n", x.area());
		System.out.printf("Triangle Y area: %.4f%n", y.area());
		if (x.area() > y.area()) {
			System.out.println("Larger area: X");
		} else {
			System.out.println("Larger area: Y");
		}
		sc.close();
	}
}
