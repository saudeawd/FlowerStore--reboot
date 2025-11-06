package flower.store;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

/**
 * Tests for FlowerBucket class.
 */
public class FlowerBucketTest {
    /** Test flower price. */
    private static final int FLOWER_PRICE = 10;
    /** Test quantity. */
    private static final int QUANTITY = 5;
    /** Expected price. */
    private static final int EXPECTED_PRICE = 50;
    /** Delta for double comparison. */
    private static final double DELTA = 0.001;
    /** Cheap flower price. */
    private static final int CHEAP_FLOWER_PRICE = 5;
    /** Cheap quantity. */
    private static final int CHEAP_QUANTITY = 2;
    /** Expensive flower price. */
    private static final int EXPENSIVE_FLOWER_PRICE = 20;
    /** Expensive quantity. */
    private static final int EXPENSIVE_QUANTITY = 3;
    /** First search price. */
    private static final int SEARCH_PRICE_1 = 50;
    /** Second search price. */
    private static final int SEARCH_PRICE_2 = 15;
    /** Third search price. */
    private static final int SEARCH_PRICE_3 = 100;
    /** Expected cheap price. */
    private static final int EXPECTED_CHEAP_PRICE = 10;

    /**
     * Tests bucket price calculation.
     */
    @Test
    public void testBucketPrice() {
        Flower flower = new Rose();
        flower.setPrice(FLOWER_PRICE);

        FlowerPack pack = new FlowerPack(flower, QUANTITY);
        FlowerBucket bucket = new FlowerBucket();
        bucket.addFlowerPack(pack);

        Assertions.assertEquals(EXPECTED_PRICE,
            bucket.getPrice(), DELTA);
    }

    /**
     * Tests store search functionality.
     */
    @Test
    public void testStoreSearch() {
        Store store = new Store();

        FlowerBucket cheapBucket = new FlowerBucket();
        Flower cheapFlower = new Tulip();
        cheapFlower.setPrice(CHEAP_FLOWER_PRICE);
        FlowerPack cheapPack = new FlowerPack(cheapFlower,
            CHEAP_QUANTITY);
        cheapBucket.addFlowerPack(cheapPack);

        FlowerBucket expensiveBucket = new FlowerBucket();
        Flower expensiveFlower = new Rose();
        expensiveFlower.setPrice(EXPENSIVE_FLOWER_PRICE);
        FlowerPack expensivePack = new FlowerPack(expensiveFlower,
            EXPENSIVE_QUANTITY);
        expensiveBucket.addFlowerPack(expensivePack);

        store.addBucket(cheapBucket);
        store.addBucket(expensiveBucket);

        var result = store.search(SEARCH_PRICE_1);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(EXPECTED_CHEAP_PRICE,
            result.get(0).getPrice(), DELTA);

        var cheapResult = store.search(SEARCH_PRICE_2);
        Assertions.assertEquals(1, cheapResult.size());
        Assertions.assertEquals(EXPECTED_CHEAP_PRICE,
            cheapResult.get(0).getPrice(), DELTA);

        var allResult = store.search(SEARCH_PRICE_3);
        Assertions.assertEquals(2, allResult.size());
    }
}
