package flower.store.payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PaymentStrategyTest {

    @Test
    public void testCreditCardPayment() {
        Payment payment = new CreditCardPaymentStrategy("1234567812345678", "12/25", "123");
        Assertions.assertTrue(payment.pay(100.0));
        Assertions.assertEquals("Credit Card", payment.getPaymentMethod());
    }

    @Test
    public void testPayPalPayment() {
        Payment payment = new PayPalPaymentStrategy("test@example.com");
        Assertions.assertTrue(payment.pay(50.0));
        Assertions.assertEquals("PayPal", payment.getPaymentMethod());
    }
}
