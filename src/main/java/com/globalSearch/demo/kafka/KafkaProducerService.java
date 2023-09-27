package com.globalSearch.demo.kafka;

import com.globalSearch.demo.entity.Customer;
import com.globalSearch.demo.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Value("${topic1.name}")
    private static String CUSTOMER_TOPIC;

    @Value("${topic2.name}")
    private static String ORDER_TOPIC;
    @Autowired
    private KafkaTemplate<String, Customer> customerKafkaTemplate;
    @Autowired
    private KafkaTemplate<String, Order> orderKafkaTemplate;

    public void sendCustomer(Customer customer) {
        customerKafkaTemplate.send(CUSTOMER_TOPIC,customer);
    }

    public void sendOrder(Order order){
        orderKafkaTemplate.send(ORDER_TOPIC,order);
    }

}
