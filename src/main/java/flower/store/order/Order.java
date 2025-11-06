package flower.store.order;

import flower.store.delivery.Delivery;
import flower.store.payment.Payment;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Item> items = new ArrayList<>();
    private Payment payment;
    private Delivery delivery;

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calculateTotalPrice() {
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        if (delivery != null) {
            total += delivery.getDeliveryPrice();
        }
        return total;
    }

    public boolean processOrder() {
        double total = calculateTotalPrice();
        if (payment == null || delivery == null) {
            return false;
        }
        
        boolean paymentSuccess = payment.pay(total);
        if (paymentSuccess) {
            return delivery.deliver("123 Main St");
        }
        return false;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public Payment getPayment() {
        return payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }
}
