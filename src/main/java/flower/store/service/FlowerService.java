package flower.store.service;

import flower.store.Flower;
import flower.store.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerService {

    @Autowired
    private FlowerRepository flowerRepository;

    public List<Flower> getAllFlowers() {
        return flowerRepository.findAll();
    }

    public Flower addFlower(Flower flower) {
        return flowerRepository.save(flower);
    }

    public List<Flower> getFlowersByMaxPrice(double maxPrice) {
        return flowerRepository.findByPriceLessThanEqual(maxPrice);
    }
}