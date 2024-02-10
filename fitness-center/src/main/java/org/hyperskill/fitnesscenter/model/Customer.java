package org.hyperskill.fitnesscenter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private LocalDate registrationDate;
    private LocalDate subscriptionEndsOn;
    private boolean isSubscriptionActive;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public LocalDate getSubscriptionEndsOn() {
        return subscriptionEndsOn;
    }

    public void setSubscriptionEndsOn(LocalDate subscriptionEndsOn) {
        this.subscriptionEndsOn = subscriptionEndsOn;
    }

    public boolean isSubscriptionActive() {
        return isSubscriptionActive;
    }

    public void setSubscriptionActive(boolean subscriptionActive) {
        isSubscriptionActive = subscriptionActive;
    }
}
