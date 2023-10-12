import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import enums.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of shapes: ");
        int numShapes = sc.nextInt();


        List<Shape> shapes = new ArrayList<>();


        for(int i = 1; i <= numShapes; i++) {
            System.out.println("Shape #" + i + " data:");
            System.out.print("Rectangle or Circle (r/c)? ");
            char shape = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Color (BLACK/BLUE/RED): ");
            String color = sc.next();


            if(shape == 'r') {
                System.out.print("Width: ");
                Double width = sc.nextDouble();
                System.out.print("Height: ");
                Double height = sc.nextDouble();
                shapes.add(new Rectangle(width, height, Color.valueOf(color)));
            } else if(shape == 'c') {
                System.out.print("Radius: ");
                Double radius = sc.nextDouble();
                shapes.add(new Circle(Color.valueOf(color), radius));
            } else
                throw new IllegalArgumentException("Forma geométrica incorreta.");

        }


        System.out.println("\nSHAPE AREAS:");
        for (Shape shape : shapes ) {
            System.out.printf("%.2f\n",shape.area());
        }


        sc.close();
    }

}