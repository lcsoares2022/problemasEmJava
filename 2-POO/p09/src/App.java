import java.util.Scanner;
import java.util.Locale;
import classes.Products;
public class App {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		Products p;
		p = new Products();
		System.out.println("Enter product data:");
		System.out.print("Name:");
		p.name = scanner.nextLine();
		System.out.print("Price:");
		p.price = scanner.nextDouble();
		System.out.print("Quantity in stock:");
		p.quantity = scanner.nextInt();
		System.out.printf("\nProduct data: %s, $ %.2f, %d, Total: $ %.2f",p.name, p.price,p.quantity,p.totalValueInStock());
		System.out.print("\n\nEnter the number of products to be added in stock:");
		int addProducts = scanner.nextInt();
		p.addProducts(addProducts);
		System.out.printf("\nUpdated data: %s, $ %.2f, %d, Total: $ %.2f",p.name, p.price,p.quantity,p.totalValueInStock());
		System.out.print("\n\nEnter the number of products to be removed in stock:");
		int removeProducts = scanner.nextInt();
		p.removeProducts(removeProducts);
		System.out.printf("\nUpdated data: %s, $ %.2f, %d units, Total: $ %.2f\n",p.name, p.price,p.quantity,p.totalValueInStock());
        scanner.close();
	}
}