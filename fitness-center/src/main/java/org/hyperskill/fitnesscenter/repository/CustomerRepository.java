package org.hyperskill.fitnesscenter.repository;

import jakarta.transaction.Transactional;
import org.hyperskill.fitnesscenter.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findBySubscriptionEndsOn(LocalDate date);
    Optional<Customer> findByPhoneNumber(String phoneNumber);
    @Transactional
    void deleteByIsSubscriptionActive(boolean isActive);
    
    boolean existsByPhoneNumber(String phoneNumber);
    
    int countBySubscriptionActive(boolean isActive);
    List<Customer> findByNameAndSurname(String name, String surname);
    List<Customer> findByNameOrPhoneNumber(String name, String phoneNumber);
    List<Customer> findBySubscriptionEndsOnBetween(LocalDate begin, LocalDate end);
    List<Customer> findBySubscriptionEndsOnLessThanEqual(LocalDate date);
    List<Customer> findByOrderBySurname();
    List<Customer> findByOrderBySurnameDesc();
    List<Customer> findTop20ByOrderByRegistrationDate();
}
