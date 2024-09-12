package com.example.onlineshopapi;

import com.example.onlineshopapi.models.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostConstruct
    public void initData() {
        // Check if there are already products in the database
        if (productRepository.count() == 0) {
            productRepository.save(new Product(1, "Produkt 1", "Beskrivelse af Produkt 1", 100, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(2, "Produkt 2", "Beskrivelse af Produkt 2", 200, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(3, "Produkt 3", "Beskrivelse af Produkt 3", 300, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(4, "Produkt 4", "Beskrivelse af Produkt 4", 400, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(5, "Produkt 5", "Beskrivelse af Produkt 5", 500, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(6, "Produkt 6", "Beskrivelse af Produkt 6", 600, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(7, "Produkt 7", "Beskrivelse af Produkt 7", 700, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(8, "Produkt 8", "Beskrivelse af Produkt 8", 3000, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(9, "Produkt 9", "Beskrivelse af Produkt 9", 770, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(10, "Produkt 10", "Beskrivelse af Produkt 10", 880, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(11, "Produkt 11", "Beskrivelse af Produkt 11", 990, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
            productRepository.save(new Product(12, "Produkt 12", "Beskrivelse af Produkt 12", 110, "https://blog.collinsdictionary.com/wp-content/uploads/sites/39/2023/03/cloth_2057252297.jpg"));
        }
    }

    @PostMapping()
    int create(@RequestBody Product product){
        productRepository.save(product);
        return product == null ? -1 : product.getId();
    }

    @GetMapping("/{id}")
    Product read(@PathVariable int id){
        return productRepository.findById(id).get();
    }

    @GetMapping()
    List<Product> getAll(){
        return productRepository.findAll();
    }

    @PutMapping("/{id}")
    void update(@RequestBody Product product){
        productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        productRepository.deleteById(id);
    }


}
