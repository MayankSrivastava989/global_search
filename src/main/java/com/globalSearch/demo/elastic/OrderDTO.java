package com.globalSearch.demo.elastic;

public class OrderDTO {

    private String orderId;

    private String clientID;

    private String superClientID;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getSuperClientID() {
        return superClientID;
    }

    public void setSuperClientID(String superClientID) {
        this.superClientID = superClientID;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId='" + orderId + '\'' +
                ", clientID='" + clientID + '\'' +
                ", superClientID='" + superClientID + '\'' +
                '}';
    }
}
