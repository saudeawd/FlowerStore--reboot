package flower.store.delivery;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DeliveryStrategyTest {

    @Test
    public void testPostDelivery() {
        Delivery delivery = new PostDeliveryStrategy();
        Assertions.assertTrue(delivery.deliver("123 Main St"));
        Assertions.assertEquals("Post Delivery", delivery.getDeliveryMethod());
        Assertions.assertEquals(10.0, delivery.getDeliveryPrice());
    }

    @Test
    public void testDHLDelivery() {
        Delivery delivery = new DHLDeliveryStrategy();
        Assertions.assertTrue(delivery.deliver("456 Oak Ave"));
        Assertions.assertEquals("DHL Delivery", delivery.getDeliveryMethod());
        Assertions.assertEquals(15.0, delivery.getDeliveryPrice());
    }
}
