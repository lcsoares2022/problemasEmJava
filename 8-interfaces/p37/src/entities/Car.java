package entities;

public class Car {

    private String model;

    private final double PRECO_POR_HORA;

    private final double PRECO_POR_DIA;

    public Car() {
        this.PRECO_POR_DIA = 0.0;
        this.PRECO_POR_HORA = 0.0;
    }

    public Car(String model, double precoPorHora, double precoPorDia) {
        this.model = model;
        PRECO_POR_HORA = precoPorHora;
        PRECO_POR_DIA = precoPorDia;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPRECO_POR_HORA() {
        return PRECO_POR_HORA;
    }

    public double getPRECO_POR_DIA() {
        return PRECO_POR_DIA;
    }
}
