package entities;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Location {


    private Car car;
    private LocalDateTime retirada;
    private LocalDateTime retorno;

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private static final double IMPOSTO_ATE_100 = 0.20;
    private static final double IMPOSTO_MAIS_DE_100 = 0.15;
  
    private double basicPayment;

    private double total;

    public Location() {
    }

    /**
     * Construtor da classe Location.
     *
     * @param car       O objeto Car associado a esta localização.
     * @param retirada   A data e hora de retirada no formato de string a ser convertida para LocalDateTime.
     * @param retorno    A data e hora de retorno no formato de string a ser convertida para LocalDateTime.
     * @throws IllegalArgumentException Se ocorrer um problema durante a conversão das strings para LocalDateTime ou
     * se as datas de retirada e retorno não forem válidas.
     */
    public Location(Car car, String retirada, String retorno) throws IllegalArgumentException {
        this.car = car;
        this.retirada = LocalDateTime.parse(retirada, fmt);
        this.retorno = LocalDateTime.parse(retorno, fmt);
        dateInvalid(this.retirada, this.retorno);
        this.setTotal();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }



    public LocalDateTime getRetirada() {
        return retirada;
    }

    public void setRetirada(LocalDateTime retirada) {
        this.retirada = retirada;
    }

    public LocalDateTime getRetorno() {
        return retorno;
    }

    public void setRetorno(LocalDateTime retorno) {
        this.retorno = retorno;
    }

    public double getBasicPayment() {
        return basicPayment;
    }

    public void setBasicPayment(double basicPayment) {
        this.basicPayment = basicPayment;
    }

    public double getTotal() {
        return total;
    }

    /**
     * Este método atribui ao total valor calculado e também seta o atributo basicPayment
     */
    public void setTotal() {
        int hourLoc = duration(retirada, retorno);

        if(hourLoc > 12) {
            this.total = totalValueBasedOnDailyRate(hourLoc);
            this.setBasicPayment(this.total);
        } else {
            this.total = car.getPRECO_POR_HORA() * hourLoc;
            this.setBasicPayment(this.total);
        }
        taxIncrement();
    }

    public void taxIncrement() {
        this.total += calcTax();
    }

    public double calcTax() {
        return this.getBasicPayment() <= 100.00 ? IMPOSTO_ATE_100 * this.getBasicPayment() :
                IMPOSTO_MAIS_DE_100 * this.getBasicPayment();
    }

    public int duration(LocalDateTime retirada, LocalDateTime retorno) {
        Duration duration = Duration.between(retirada, retorno);
        long qtdMinutes = duration.toMinutes();
        double hours = qtdMinutes / 60.00;
        return round(hours);
    }

    public static int round(double duration) {
        return (int) Math.ceil(duration);
    }

    public void dateInvalid(LocalDateTime retirada, LocalDateTime retorno) throws IllegalArgumentException{
        boolean isValid = retorno.isAfter(retirada);
        if(!isValid)
            throw new IllegalArgumentException("A data de retirada está para depois da data de retorno");
    }

    public double totalValueBasedOnDailyRate(int durationHours) {
        if (durationHours > 24) {
            double durDays = durationHours / 24.00;
            int days = round(durDays);
            return this.getCar().getPRECO_POR_DIA() * days;
        }

        return this.getCar().getPRECO_POR_DIA() * 1;
    }

    @Override
    public String toString() {
        return "INVOICE: "
        + "\nBasic payment: "
        + String.format("%.2f", this.getBasicPayment())
        + "\nTax: "
        + String.format("%.2f", calcTax())
        + "\nTotal payment: "
        + String.format("%.2f", this.getTotal());
    }




}
