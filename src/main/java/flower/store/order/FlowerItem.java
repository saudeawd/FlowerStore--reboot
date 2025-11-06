package flower.store.order;

import flower.store.Flower;

public class FlowerItem implements Item {
    private Flower flower;
    private int quantity;

    public FlowerItem(Flower flower, int quantity) {
        this.flower = flower;
        this.quantity = quantity;
    }

    @Override
    public double getPrice() {
        return flower.getPrice() * quantity;
    }

    @Override
    public String getDescription() {
        return quantity + " x " + flower.getFlowerType() + " (" + flower.getColor() + ")";
    }

    public Flower getFlower() {
        return flower;
    }

    public int getQuantity() {
        return quantity;
    }
}
