import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MM/YYYY): ");
        String birthDate = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Client client = new Client(name,email,sdf.parse(birthDate));


        System.out.println("Enter order data:");
        System.out.print("Status: ");
        String status = sc.nextLine();
        System.out.print("Hou many items to this order? ");
        Integer qtdItem = sc.nextInt();


        Order order = new Order(new Date(), OrderStatus.valueOf(status.toUpperCase()), client);
        for(int i = 1; i<= qtdItem; i++) {
            sc.nextLine();
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            Double price = sc.nextDouble();
            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();
            Product product = new Product(productName, price);
            OrderItem orderItem = new OrderItem(quantity,product);
            order.addItem(orderItem);
        }
        System.out.println();
        System.out.println(order);

        sc.close();

        }
}
