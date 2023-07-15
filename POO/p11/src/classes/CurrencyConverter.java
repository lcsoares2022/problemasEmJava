package classes;

public class CurrencyConverter {
    public static final double IOF = 0.06;
    
    public static double comprarDolar(double priceDolar, double qtdDolar) {
        double qtdPaidDolar;
        qtdPaidDolar = priceDolar * qtdDolar;
        return qtdPaidDolar + (qtdPaidDolar * IOF);
    }
}
