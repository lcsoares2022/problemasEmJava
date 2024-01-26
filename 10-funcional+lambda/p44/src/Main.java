import models.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Product> products = new ArrayList<>();
            String line = br.readLine();

            while(line != null) {
                String[] data = line.split(",");
                Product product = new Product(data[0],Double.parseDouble(data[1]));
                products.add(product);
                line = br.readLine();
            }


            OptionalDouble average = products.stream()
                    .mapToDouble(Product::getPrice)
                    .average();

            double result = average.orElse(0.0);

            Comparator<Product> comp = (p1,p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());

            List<Product> belowAverage = products.stream()
                    .filter(x -> x.getPrice() < result)
                    .sorted(comp.reversed()).toList();

            System.out.println("Average price: " + String.format("%.2f", result));
            belowAverage.forEach(x -> System.out.println(x.getName()));

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }


        sc.close();



    }
}


// todo(1):