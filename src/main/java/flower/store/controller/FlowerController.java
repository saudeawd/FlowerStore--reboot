package flower.store.controller;

import flower.store.Flower;
import flower.store.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flowers")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;

    @GetMapping
    public List<Flower> getFlowers() {
        return flowerService.getAllFlowers();
    }

    @PostMapping
    public Flower addFlower(@RequestBody Flower flower) {
        return flowerService.addFlower(flower);
    }

    @GetMapping("/search")
    public List<Flower> getFlowersByPrice(@RequestParam double maxPrice) {
        return flowerService.getFlowersByMaxPrice(maxPrice);
    }
}