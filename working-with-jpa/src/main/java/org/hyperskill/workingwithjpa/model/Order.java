package org.hyperskill.workingwithjpa.model;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "orders")
public class Order {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;
    
    @Column(name = "product_type") // Not requested converted automatically
    private String productType;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "order_date")
    private Date orderDate;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private Status orderStatus;
    
    @Transient
    private String orderProgress;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Status getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Status orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderProgress() {
        return orderProgress;
    }

    public void setOrderProgress(String orderProgress) {
        this.orderProgress = orderProgress;
    }
}
