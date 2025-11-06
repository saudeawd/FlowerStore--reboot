package flower.store.controller;

import flower.store.delivery.DHLDeliveryStrategy;
import flower.store.delivery.Delivery;
import flower.store.delivery.PostDeliveryStrategy;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {

    @GetMapping("/post")
    public Map<String, Object> getPostDeliveryInfo() {
        Delivery delivery = new PostDeliveryStrategy();
        return Map.of(
            "method", delivery.getDeliveryMethod(),
            "price", delivery.getDeliveryPrice(),
            "description", "Standard post delivery"
        );
    }

    @GetMapping("/dhl")
    public Map<String, Object> getDHLDeliveryInfo() {
        Delivery delivery = new DHLDeliveryStrategy();
        return Map.of(
            "method", delivery.getDeliveryMethod(),
            "price", delivery.getDeliveryPrice(),
            "description", "Express DHL delivery"
        );
    }

    @PostMapping("/post")
    public Map<String, String> schedulePostDelivery(@RequestBody Map<String, String> deliveryDetails) {
        Delivery delivery = new PostDeliveryStrategy();
        boolean success = delivery.deliver(deliveryDetails.get("address"));
        
        return Map.of(
            "status", success ? "SCHEDULED" : "FAILED",
            "method", delivery.getDeliveryMethod(),
            "message", success ? "Delivery scheduled successfully" : "Delivery scheduling failed"
        );
    }

    @PostMapping("/dhl")
    public Map<String, String> scheduleDHLDelivery(@RequestBody Map<String, String> deliveryDetails) {
        Delivery delivery = new DHLDeliveryStrategy();
        boolean success = delivery.deliver(deliveryDetails.get("address"));
        
        return Map.of(
            "status", success ? "SCHEDULED" : "FAILED",
            "method", delivery.getDeliveryMethod(),
            "message", success ? "Delivery scheduled successfully" : "Delivery scheduling failed"
        );
    }
}
