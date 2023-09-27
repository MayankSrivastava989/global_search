package com.globalSearch.demo.service;

import com.globalSearch.demo.elastic.OrderDAO;
import com.globalSearch.demo.repo.OrderDAORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDAOService {

    @Autowired
    private OrderDAORepo orderDAORepo;

    public OrderDAO addOrder(OrderDAO order){
        return orderDAORepo.save(order);
    }

    public OrderDAO getOrderById(String id)
    {
        OrderDAO orderDAO=null;
        try {
            orderDAO= orderDAORepo.findById(id).get();
            return orderDAO;
        }catch (Exception e){
            return orderDAO;
        }
    }

    public Iterable<OrderDAO> getAll(){
        return orderDAORepo.findAll();
    }
}
