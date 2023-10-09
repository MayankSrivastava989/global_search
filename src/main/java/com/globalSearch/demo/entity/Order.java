package com.globalSearch.demo.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orderTable")
public class Order {
    @Id
    private String orderId;
    private String orderName;
    private String orderDescription;
    private String clientId;
    private String superClientId;
    private LocalDateTime orderDate;
    private long amount;
    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSuperClientId() {
        return superClientId;
    }

    public void setSuperClientId(String superClientId) {
        this.superClientId = superClientId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Order() {
    }

    public Order(String orderId, String orderName, String orderDescription, String clientId, String superClientId, LocalDateTime orderDate, long amount, String customerId) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.orderDescription = orderDescription;
        this.clientId = clientId;
        this.superClientId = superClientId;
        this.orderDate = orderDate;
        this.amount = amount;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderDescription='" + orderDescription + '\'' +
                ", clientId='" + clientId + '\'' +
                ", superClientId='" + superClientId + '\'' +
                ", orderDate=" + orderDate +
                ", amount=" + amount +
                ", customerId='" + customerId + '\'' +
                '}';
    }
}
