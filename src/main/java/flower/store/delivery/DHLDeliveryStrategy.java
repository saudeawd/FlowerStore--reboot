package flower.store.delivery;

public class DHLDeliveryStrategy implements Delivery {
    private static final double DELIVERY_PRICE = 15.0;

    @Override
    public boolean deliver(String address) {
        System.out.println("Delivering via DHL to: " + address);
        System.out.println("Delivery cost: $" + DELIVERY_PRICE);
        return true;
    }

    @Override
    public String getDeliveryMethod() {
        return "DHL Delivery";
    }

    @Override
    public double getDeliveryPrice() {
        return DELIVERY_PRICE;
    }
}
