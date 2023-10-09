package com.globalSearch.demo.service;

import com.globalSearch.demo.entity.Customer;
import com.globalSearch.demo.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public Customer addCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public Customer getCustomerById(String id){
        Customer customer=null;
        try {
            customer=customerRepo.findById(id).get();
            return customer;
        }
        catch (Exception e){
            return customer;
        }
    }

    public void deleteById(String id){
        customerRepo.deleteById(id);
    }
}
