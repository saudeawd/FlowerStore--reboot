package flower.store.decorator;

import flower.store.order.Item;

public class BasketDecorator extends AbstractDecorator {
    private static final double BASKET_PRICE = 8.0;

    public BasketDecorator(Item decoratedItem) {
        super(decoratedItem);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + BASKET_PRICE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", in a beautiful basket";
    }
}