package flower.store.decorator;

import flower.store.Flower;
import flower.store.FlowerColor;
import flower.store.FlowerType;
import flower.store.order.FlowerItem;
import flower.store.order.Item;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DecoratorTest {

    @Test
    public void testRibbonDecorator() {
        Flower flower = new Flower(FlowerType.ROSE, FlowerColor.RED, 45.0, 10.0);
        Item flowerItem = new FlowerItem(flower, 1);
        Item decoratedItem = new RibbonDecorator(flowerItem);

        Assertions.assertEquals(50.0, decoratedItem.getPrice());
        Assertions.assertTrue(decoratedItem.getDescription().contains("ribbon"));
    }

    @Test
    public void testPaperDecorator() {
        Flower flower = new Flower(FlowerType.TULIP, FlowerColor.RED, 30.0, 8.0);
        Item flowerItem = new FlowerItem(flower, 2);
        Item decoratedItem = new PaperDecorator(flowerItem);

        Assertions.assertEquals(63.0, decoratedItem.getPrice());
        Assertions.assertTrue(decoratedItem.getDescription().contains("paper"));
    }

    @Test
    public void testMultipleDecorators() {
        Flower flower = new Flower(FlowerType.CHAMOMILE, FlowerColor.BLUE, 25.0, 6.0);
        Item flowerItem = new FlowerItem(flower, 1);
        Item decoratedItem = new BasketDecorator(new RibbonDecorator(flowerItem));

        Assertions.assertEquals(38.0, decoratedItem.getPrice());
        Assertions.assertTrue(decoratedItem.getDescription().contains("basket"));
        Assertions.assertTrue(decoratedItem.getDescription().contains("ribbon"));
    }
}
