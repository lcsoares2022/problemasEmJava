package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public final class UsedProduct extends Product{

    private LocalDate manufactureDate;

    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public UsedProduct() {

        super();
    }

    public UsedProduct(String name, Double price, String manufactureDate) {
        super(name, price);
        this.manufactureDate = LocalDate.parse(manufactureDate, fmt);
    }


    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }


    @Override
    public String priceTag() {
        return this.getName()
             + " (used) "
             + "$ "
             + String.format("%.2f", this.getPrice())
             + " (Manufacture date: "
             + this.getManufactureDate().format(fmt)
             + ")";
    }

}
