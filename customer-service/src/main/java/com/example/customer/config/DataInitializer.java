package com.example.customer.config;

import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initializeData(CustomerRepository customerRepository) {
        return args -> {
            // Create sample customers
            Customer customer1 = new Customer(null, "Ahmed", "Taha", "ahmed.taha@example.com",
                                             "0612345678", "123 Rue de la Paix, Casablanca");
            Customer customer2 = new Customer(null, "Fatima", "Hassan", "fatima.hassan@example.com",
                                             "0698765432", "456 Avenue Mohammed V, Rabat");
            Customer customer3 = new Customer(null, "Mohamed", "Ali", "mohamed.ali@example.com",
                                             "0655443322", "789 Rue Andalouse, Fes");

            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);

            System.out.println("Sample customers initialized successfully!");
        };
    }
}

