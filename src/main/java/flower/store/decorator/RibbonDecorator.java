package flower.store.decorator;

import flower.store.order.Item;

public class RibbonDecorator extends AbstractDecorator {
    private static final double RIBBON_PRICE = 5.0;

    public RibbonDecorator(Item decoratedItem) {
        super(decoratedItem);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + RIBBON_PRICE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", decorated with ribbon";
    }
}