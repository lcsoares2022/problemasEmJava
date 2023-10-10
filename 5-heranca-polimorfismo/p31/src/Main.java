import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int numProducts = sc.nextInt();

        List<Product> listProduct = new ArrayList<>();


        for(int i = 1; i <= numProducts; i++) {
            System.out.println("Product #" + i + " data:" );
            System.out.print("Common, used or imported (c/u/i)? ");
            char selectProduct = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            sc.nextLine();
            if(selectProduct == 'i') {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                listProduct.add(new ImportedProduct(name, price, customsFee));
            } else if(selectProduct == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String manufactureDate = sc.nextLine();
                listProduct.add(new UsedProduct(name, price, manufactureDate));
            } else if (selectProduct == 'c') {
                listProduct.add(new Product(name, price));
            } else
                throw new RuntimeException("Dado inválido: só é permitido i, c e u.");
        }

        System.out.println("\nPRICE TAGS:");
        for (Product p : listProduct) {
            System.out.println(p.priceTag());
        }

        sc.close();

    }

}