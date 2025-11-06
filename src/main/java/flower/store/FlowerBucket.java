package flower.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bucket containing multiple flower packs.
 */
public class FlowerBucket {
    /** List of flower packs in this bucket. */
    private List<FlowerPack> flowerPacks = new ArrayList<>();

    /**
     * Adds a flower pack to the bucket.
     * @param flowerPack the flower pack to add
     */
    public void addFlowerPack(final FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    /**
     * Calculates the total price of all flower packs in the bucket.
     * @return the total price
     */
    public double getPrice() {
        double total = 0;
        for (FlowerPack pack : flowerPacks) {
            total += pack.getPrice();
        }
        return total;
    }
}
