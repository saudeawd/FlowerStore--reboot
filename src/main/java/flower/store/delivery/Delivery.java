package flower.store.delivery;

public interface Delivery {
    boolean deliver(String address);
    String getDeliveryMethod();
    double getDeliveryPrice();
}
