import models.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
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
            }


        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }







        sc.close();



    }
}