package flower.store.payment;

public interface Payment {
    boolean pay(double amount);
    String getPaymentMethod();
}
