package org.hyperskill.demo;

import javax.print.event.PrintJobAttributeEvent;

public class Customer {
    private final String name;
    private final String address;
    
    Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    public String getName() {
        return name;
    }
    
    public String getAddress() {
        return address;
    }
    
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
