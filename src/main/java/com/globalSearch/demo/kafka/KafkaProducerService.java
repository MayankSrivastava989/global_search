package com.globalSearch.demo.kafka;

import com.globalSearch.demo.entity.Customer;
import com.globalSearch.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static int partition=0;
    private final static String CUSTOMER_TOPIC="customer";
    private final static String ORDER_TOPIC="order";
    @Autowired
    private KafkaTemplate<String, Customer> customerKafkaTemplate;
    @Autowired
    private KafkaTemplate<String, Order> orderKafkaTemplate;

    public void sendCustomer(Customer customer) {
        customerKafkaTemplate.send(CUSTOMER_TOPIC,customer);
    }
    public void sendOrder(Order order){
        orderKafkaTemplate.send(ORDER_TOPIC,partition,order.getOrderId(),order);
        if(partition<2)
        partition++;
        else
            partition=0;
    }
}
