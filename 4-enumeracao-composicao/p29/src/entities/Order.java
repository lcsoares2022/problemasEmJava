package entities;

import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private Date moment;
    private OrderStatus status;
    private List<OrderItem> orderItems;

    private Client client;

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
        this.orderItems = new ArrayList<>();
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItem(OrderItem item) {
        orderItems.add(item);
    }

    public void removeItem(OrderItem item) {
        orderItems.remove(item);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Double total() {
        double total=0.0;

        for (OrderItem orderItem : this.getOrderItems()) {
            total += orderItem.subTotal();
        }

        return total;
    }


    public String toString() {

        return "ORDER SUMMARY:\n"
                + "Order moment: "
                + sdf.format(this.getMoment())
                + "\n"
                + "Order status: "
                + this.getStatus().name()
                + "\n"
                + this.getClient().toString()
                + "\n"
                + "Order items:"
                + "\n"
                + displayOrderItem()
                + "Total price: $"
                + this.total();
    }

    public String displayOrderItem() {
        StringBuilder orderItemString = new StringBuilder();
        for(OrderItem orderItem : this.getOrderItems()) {
            orderItemString.append(orderItem.toString()).append("\n");
        }
        return orderItemString.toString();
    }


}
