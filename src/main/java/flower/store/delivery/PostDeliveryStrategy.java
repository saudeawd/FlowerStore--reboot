package flower.store.delivery;

public class PostDeliveryStrategy implements Delivery {
    private static final double DELIVERY_PRICE = 10.0;

    @Override
    public boolean deliver(String address) {
        System.out.println("Delivering via Post to: " + address);
        System.out.println("Delivery cost: $" + DELIVERY_PRICE);
        return true;
    }

    @Override
    public String getDeliveryMethod() {
        return "Post Delivery";
    }

    @Override
    public double getDeliveryPrice() {
        return DELIVERY_PRICE;
    }
}
