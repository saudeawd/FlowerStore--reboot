package flower.store;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a store that sells flower buckets.
 */
public class Store {
    /** List of available flower buckets. */
    private List<FlowerBucket> buckets = new ArrayList<>();

    /**
     * Adds a flower bucket to the store.
     * @param bucket the bucket to add
     */
    public void addBucket(final FlowerBucket bucket) {
        buckets.add(bucket);
    }

    /**
     * Searches for flower buckets within the given price range.
     * @param maxPrice the maximum price
     * @return list of affordable buckets
     */
    public List<FlowerBucket> search(final double maxPrice) {
        List<FlowerBucket> result = new ArrayList<>();
        for (FlowerBucket bucket : buckets) {
            if (bucket.getPrice() <= maxPrice) {
                result.add(bucket);
            }
        }
        return result;
    }
}
