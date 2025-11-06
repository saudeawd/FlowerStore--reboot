package flower.store.decorator;

import flower.store.order.Item;

public abstract class AbstractDecorator implements Item {
    protected Item decoratedItem;

    public AbstractDecorator(Item decoratedItem) {
        this.decoratedItem = decoratedItem;
    }

    @Override
    public double getPrice() {
        return decoratedItem.getPrice();
    }

    @Override
    public String getDescription() {
        return decoratedItem.getDescription();
    }
}