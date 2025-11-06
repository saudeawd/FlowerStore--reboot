package flower.store.order;

import flower.store.Flower;
import flower.store.FlowerColor;
import flower.store.FlowerType;
import flower.store.delivery.DHLDeliveryStrategy;
import flower.store.delivery.Delivery;
import flower.store.payment.CreditCardPaymentStrategy;
import flower.store.payment.Payment;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class OrderTest {

    @Test
    public void testOrderProcessing() {
        Order order = new Order();
        
        Flower rose = new Flower(FlowerType.ROSE, FlowerColor.RED, 45.0, 10.0);
        FlowerItem roseItem = new FlowerItem(rose, 2);
        
        order.addItem(roseItem);
        
        Payment payment = new CreditCardPaymentStrategy("1234567812345678", "12/25", "123");
        Delivery delivery = new DHLDeliveryStrategy();
        
        order.setPayment(payment);
        order.setDelivery(delivery);
        
        double total = order.calculateTotalPrice();
        Assertions.assertEquals(45.0 * 2 + 15.0, total);
        
        boolean processed = order.processOrder();
        Assertions.assertTrue(processed);
    }
}
