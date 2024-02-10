package org.hyperskill.fitnesscenter;

import org.hyperskill.fitnesscenter.exception.UniqueConstraintException;
import org.hyperskill.fitnesscenter.model.Customer;
import org.hyperskill.fitnesscenter.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class FitnessCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FitnessCenterApplication.class, args);
    }

    @Component
    public class Runner implements CommandLineRunner {
        private final CustomerRepository repository;
        
        public Runner(CustomerRepository repository) {
            this.repository = repository;
        }
        
        @Override
        public void run(String... args) {
            // Get List of customer with subscription that ends today
            List<Customer> customerList = repository.findBySubscriptionEndsOn(LocalDate.now());
            
            // Delete Customer with no subscriptions
            repository.deleteByIsSubscriptionActive(false);

            // throws exception if phoneNumber is in database
            if (repository.existsByPhoneNumber("1234")) {
                throw new UniqueConstraintException("Phone number already taken");
            }
            
            // Get List of customer between now and now + 1 month
            LocalDate today = LocalDate.now();
            List<Customer> customerList1 = repository
                    .findBySubscriptionEndsOnBetween(today, today.plusMonths(1));
        }
    }
}
