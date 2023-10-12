package entities;

import enums.Color;

public class Circle extends Shape{

    private Double radius;

    private final Double PI = 3.14159265359;


    public Circle() {
        super();
    }

    public Circle(Color color, Double radius) {
        super(color);
        this.radius = radius;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double area() {
        return PI * Math.pow(this.getRadius(),2);
    }
}
