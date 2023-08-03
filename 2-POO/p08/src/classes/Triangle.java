package classes;

public class Triangle {
    public static double l1;
    public static double l2;
    public static double l3;

    public double area() {
        double p;
        p = (l1 + l2 + l3) / 2.0;
        return Math.sqrt(p * (p - l1) * (p - l2) * (p -l3));
    }
}
