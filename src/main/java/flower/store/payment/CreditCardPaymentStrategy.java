package flower.store.payment;

public class CreditCardPaymentStrategy implements Payment {
    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPaymentStrategy(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public boolean pay(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        System.out.println("Card: " + maskCardNumber(cardNumber));
        System.out.println("Expiry: " + expiryDate);
        return true;
    }

    @Override
    public String getPaymentMethod() {
        return "Credit Card";
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.length() <= 4) return cardNumber;
        return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
    }

    public String getCardNumber() {
        return maskCardNumber(cardNumber);
    }

    public String getExpiryDate() {
        return expiryDate;
    }
}
