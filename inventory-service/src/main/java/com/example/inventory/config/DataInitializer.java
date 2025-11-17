package com.example.inventory.config;

import com.example.inventory.model.Product;
import com.example.inventory.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initializeData(ProductRepository productRepository) {
        return args -> {
            // Create sample products
            Product product1 = new Product(null, "Laptop Dell XPS 13", "High-performance ultrabook",
                                          1299.99, 50, "DELL-XPS-13");
            Product product2 = new Product(null, "Mouse Logitech MX Master", "Wireless mouse for productivity",
                                          99.99, 150, "LOG-MX-MASTER");
            Product product3 = new Product(null, "Keyboard Mechanical RGB", "Gaming mechanical keyboard",
                                          149.99, 75, "KEY-MECH-RGB");
            Product product4 = new Product(null, "Monitor ASUS 27inch 4K", "4K UHD display monitor",
                                          599.99, 30, "ASUS-MON-27");
            Product product5 = new Product(null, "Webcam Logitech C920", "HD webcam for video conferencing",
                                          79.99, 100, "LOG-WEBCAM-C920");

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);
            productRepository.save(product5);

            System.out.println("Sample products initialized successfully!");
        };
    }
}

