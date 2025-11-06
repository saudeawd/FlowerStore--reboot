package flower.store.decorator;

import flower.store.order.Item;

public class PaperDecorator extends AbstractDecorator {
    private static final double PAPER_PRICE = 3.0;

    public PaperDecorator(Item decoratedItem) {
        super(decoratedItem);
    }

    @Override
    public double getPrice() {
        return super.getPrice() + PAPER_PRICE;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", wrapped in paper";
    }
}