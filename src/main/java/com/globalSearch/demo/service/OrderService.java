package com.globalSearch.demo.service;

import com.globalSearch.demo.entity.Order;
import com.globalSearch.demo.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public Order addOrder(Order order)
    {
        return orderRepo.save(order);
    }

    public void deleteOrderById(String id)
    {
        orderRepo.deleteById(id);
    }

    public List<Order> getAllOrder(){
        return orderRepo.findAll();
    }

    public Order getOrderById(String id){
        Order order=null;
        try {
            order=orderRepo.findById(id).get();
        }
        catch (Exception e){
            return order;
        }
        return order;
    }

}
