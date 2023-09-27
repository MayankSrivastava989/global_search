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
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private static final String ORDER_TOPIC="order-topic";

    private static final String CUSTOMER_TOPIC="customer-topic";
    @Autowired
    private OrderDAOService orderDAOService;
    @Autowired
    private CustomerDAOService customerDAOService;
    @KafkaListener(topics = ORDER_TOPIC, groupId = "order-consumer")
    public void orderlisten(Order order) {
        OrderDAO orderDAO= CustomMapper.mapOrderToOrderDAO(order);
        CustomerDAO customerDAO=customerDAOService.getCustomerById(order.getCustomerId());
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setOrderId(order.getOrderId());
        orderDTO.setClientID(order.getClientId());
        orderDTO.setSuperClientID(order.getSuperClientId());
        customerDAO.getOrderList().add(orderDTO);
        customerDAOService.addCustomer(customerDAO);
        orderDAOService.addOrder(orderDAO);
    }
    @KafkaListener(topics = CUSTOMER_TOPIC,groupId = "customer-consumer")
    public void customerlisten(Customer customer){
        CustomerDAO customerDAO= CustomMapper.mapCustomerToCustomerDAO(customer);
        customerDAOService.addCustomer(customerDAO);
    }
}
