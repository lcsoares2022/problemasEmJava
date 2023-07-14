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
		double p = (x.l1 +x.l2 + x.l3) / 2.0;
		double areaX = Math.sqrt(p * (p - x.l1) * (p - x.l2) * (p - x.l3));
		p = (y.l1 + y.l2 + y.l3) / 2.0;
		double areaY = Math.sqrt(p * (p - y.l1) * (p - y.l2) * (p - y.l3));
		System.out.printf("Triangle X area: %.4f%n", areaX);
		System.out.printf("Triangle Y area: %.4f%n", areaY);
		if (areaX > areaY) {
			System.out.println("Larger area: X");
		} else {
			System.out.println("Larger area: Y");
		}
		sc.close();
	}
}
