package entities;

public class OrderItem {
    private Integer quantity;
    private Double price;

    private Product product;

    public OrderItem(Integer quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
        this.price = this.product.getPrice();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double subTotal() {
        return this.getQuantity() * this.getPrice();
    }

    public String toString() {
        return this.product.getName()
            + ", $"
            + this.getPrice()
            + ", "
            + "Quantity: "
            + this.getQuantity()
            + ", "
            + "Subtotal: $"
            + this.subTotal();
    }
}
