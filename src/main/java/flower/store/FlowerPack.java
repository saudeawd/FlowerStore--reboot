package flower.store;

/**
 * Represents a pack of flowers.
 */
public class FlowerPack {
    /** The flower in this pack. */
    private Flower flower;
    /** The quantity of flowers in this pack. */
    private int quantity;

    /**
     * Constructs a flower pack.
     * @param packFlower the flower
     * @param packQuantity the quantity
     */
    public FlowerPack(final Flower packFlower, final int packQuantity) {
        this.flower = packFlower;
        this.quantity = packQuantity;
    }

    /**
     * Gets the flower.
     * @return the flower
     */
    public Flower getFlower() {
        return flower;
    }

    /**
     * Gets the quantity.
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Calculates the total price of the flower pack.
     * @return the total price
     */
    public double getPrice() {
        return flower.getPrice() * quantity;
    }
}
