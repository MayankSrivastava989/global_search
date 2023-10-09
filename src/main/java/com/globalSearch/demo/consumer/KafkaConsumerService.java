package com.globalSearch.demo.consumer;

import com.globalSearch.demo.elastic.CustomerDAO;
import com.globalSearch.demo.elastic.OrderDAO;
import com.globalSearch.demo.elastic.OrderDTO;
import com.globalSearch.demo.entity.Customer;
import com.globalSearch.demo.entity.Order;
import com.globalSearch.demo.mapper.CustomMapper;
import com.globalSearch.demo.service.CustomerDAOService;
import com.globalSearch.demo.service.OrderDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final String ORDER_TOPIC="order";

    private static final String CUSTOMER_TOPIC="customer";
    @Autowired
    private OrderDAOService orderDAOService;
    @Autowired
    private CustomerDAOService customerDAOService;

    private void processOrder(Order order) {
        OrderDAO orderDAO = CustomMapper.mapOrderToOrderDAO(order);
        CustomerDAO customerDAO = customerDAOService.getCustomerById(order.getCustomerId());
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setClientID(order.getClientId());
        orderDTO.setSuperClientID(order.getSuperClientId());
        customerDAO.getOrderList().add(orderDTO);
        customerDAOService.addCustomer(customerDAO);
        orderDAOService.addOrder(orderDAO);
    }


    @KafkaListener(topicPartitions = @TopicPartition(topic = ORDER_TOPIC, partitions = {"0"}), groupId = "my-consumer")
//   @KafkaListener(topics = ORDER_TOPIC, groupId = "my-consumer")
    public void orderlisten(Order order) {
        processOrder(order);
    System.out.println("order been added through partition 0");
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = ORDER_TOPIC, partitions = {"1"}), groupId = "my-consumer")
    public void orderlisten1(Order order) {
        processOrder(order);
        System.out.println("order been added through partition 1");
    }
    @KafkaListener(topicPartitions = @TopicPartition(topic = ORDER_TOPIC, partitions = {"2"}), groupId = "my-consumer")
    public void orderlisten2(Order order) {
        processOrder(order);
        System.out.println("order been added through partition 2");
    }

//    @KafkaListener(topics =ORDER_TOPIC ,groupId = "my-consumer")
//    public void genericOrderListener(Order order, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition) {
//        processOrder(order);
//        System.out.println("Order received from topic: "  + ", partition: " + partition);
//    }

    @KafkaListener(topics = CUSTOMER_TOPIC,groupId = "my-consumer")
    public void customerlisten(Customer customer){
        CustomerDAO customerDAO= CustomMapper.mapCustomerToCustomerDAO(customer);
        customerDAOService.addCustomer(customerDAO);

    }
}
