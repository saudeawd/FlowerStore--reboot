package flower.store.controller;

import flower.store.payment.CreditCardPaymentStrategy;
import flower.store.payment.PayPalPaymentStrategy;
import flower.store.payment.Payment;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @PostMapping("/credit-card")
    public Map<String, String> processCreditCardPayment(@RequestBody Map<String, String> paymentDetails) {
        Payment payment = new CreditCardPaymentStrategy(
            paymentDetails.get("cardNumber"),
            paymentDetails.get("expiryDate"),
            paymentDetails.get("cvv")
        );
        
        boolean success = payment.pay(Double.parseDouble(paymentDetails.get("amount")));
        
        return Map.of(
            "status", success ? "SUCCESS" : "FAILED",
            "method", payment.getPaymentMethod(),
            "message", success ? "Payment processed successfully" : "Payment failed"
        );
    }

    @PostMapping("/paypal")
    public Map<String, String> processPayPalPayment(@RequestBody Map<String, String> paymentDetails) {
        Payment payment = new PayPalPaymentStrategy(paymentDetails.get("email"));
        
        boolean success = payment.pay(Double.parseDouble(paymentDetails.get("amount")));
        
        return Map.of(
            "status", success ? "SUCCESS" : "FAILED",
            "method", payment.getPaymentMethod(),
            "message", success ? "Payment processed successfully" : "Payment failed"
        );
    }
}
