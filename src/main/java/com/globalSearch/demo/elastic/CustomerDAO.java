package com.globalSearch.demo.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.List;

@Document(indexName = "customer")
public class CustomerDAO {
    @Id
    private String customerId;
    private String firstName;
    private String secondName;
    private String street;
    private String city;
    private String state;
    private List<OrderDTO> orderList;
    public List<OrderDTO> getOrderList() {
        return orderList;
    }
    public void setOrderList(List<OrderDTO> orderList) {
        this.orderList = orderList;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CustomerDAO(String customerId, String firstName, String secondName, String street, String city, String state, List<OrderDTO> orderList) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.orderList = orderList;
    }

    public CustomerDAO() {
    }

    @Override
    public String toString() {
        return "CustomerDAO{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", orderList=" + orderList +
                '}';
    }
}
