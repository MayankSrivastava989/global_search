package com.globalSearch.demo.mapper;

import com.globalSearch.demo.elastic.CustomerDAO;
import com.globalSearch.demo.elastic.OrderDAO;
import com.globalSearch.demo.elastic.OrderDTO;
import com.globalSearch.demo.entity.Customer;
import com.globalSearch.demo.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class CustomMapper {

    public static OrderDAO mapOrderToOrderDAO(Order order){
        return new OrderDAO(order.getOrderId(), order.getOrderName(),
                order.getOrderDescription(),order.getClientId(),order.getSuperClientId(),
        order.getOrderDate(),order.getAmount());
    }

    public static CustomerDAO mapCustomerToCustomerDAO(Customer customer){
        List<OrderDTO> list=new ArrayList<>();
        return new CustomerDAO(customer.getCustomerId(),
               customer.getFirstName(),customer.getSecondName(),customer.getStreet(),
              customer.getCity(),customer.getState(),list);
    }


}
