package flower.store;

import jakarta.persistence.*;

@Entity
@Table(name = "flowers")
public class Flower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Enumerated(EnumType.STRING)
    private FlowerType flowerType;
    
    @Enumerated(EnumType.STRING)
    private FlowerColor color;
    
    private double price;
    private double sepalLength;

    public Flower() {}

    public Flower(FlowerType flowerType, FlowerColor color, double price, double sepalLength) {
        this.flowerType = flowerType;
        this.color = color;
        this.price = price;
        this.sepalLength = sepalLength;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public FlowerType getFlowerType() { return flowerType; }
    public void setFlowerType(FlowerType flowerType) { this.flowerType = flowerType; }
    
    public String getColor() { return color.toString(); }
    public void setColor(FlowerColor color) { this.color = color; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    
    public double getSepalLength() { return sepalLength; }
    public void setSepalLength(double sepalLength) { this.sepalLength = sepalLength; }
}