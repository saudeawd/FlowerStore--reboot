package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import org.junit.jupiter.api.Assertions;

/**
 * Tests for Flower class.
 */
public class FlowerTest {
    /** Random generator for tests. */
    private static final Random RANDOM_GENERATOR = new Random();
    /** Maximum price for tests. */
    private static final int MAX_PRICE = 100;
    /** Flower instance for testing. */
    private Flower flower;

    /**
     * Sets up test environment before each test.
     */
    @BeforeEach
    public void init() {
        flower = new Flower();
    }

    /**
     * Tests price getter and setter.
     */
    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        flower.setPrice(price);
        Assertions.assertEquals(price, flower.getPrice());
    }

    /**
     * Tests color getter and setter.
     */
    @Test
    public void testColor() {
        FlowerColor color = FlowerColor.RED;
        flower.setColor(color);
        Assertions.assertEquals("#FF0000", flower.getColor());
    }
}
