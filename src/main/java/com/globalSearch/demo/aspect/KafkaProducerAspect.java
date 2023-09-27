package com.globalSearch.demo.aspect;

import com.globalSearch.demo.entity.Customer;
import com.globalSearch.demo.entity.Order;
import com.globalSearch.demo.kafka.KafkaProducerService;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class KafkaProducerAspect {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @AfterReturning(
            pointcut = "execution(* com.globalSearch.demo.service.OrderService.addOrder(..))",
            returning = "order"
    )
    public void sendOrderToKafkaOnSuccessfulAddition(Order order) {
        kafkaProducerService.sendOrder(order);
    }

    @AfterReturning(
            pointcut = "execution(* com.globalSearch.demo.service.CustomerService.addCustomer(..))",
            returning = "customer"
    )
    public void sendCustomerToKafkaOnSuccessfulAddition(Customer customer) {
        kafkaProducerService.sendCustomer(customer);
    }

}
