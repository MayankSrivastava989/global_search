package com.globalSearch.demo.service;

import com.globalSearch.demo.elastic.CustomerDAO;
import com.globalSearch.demo.repo.CustomerDAORepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDAOService {
    @Autowired
    private CustomerDAORepo customerDAORepo;

    public CustomerDAO addCustomer(CustomerDAO customerDAO){
       return customerDAORepo.save(customerDAO);
    }

    public CustomerDAO getCustomerById(String id)
    {
        CustomerDAO customerDAO=null;
        try{
            customerDAO=customerDAORepo.findById(id).get();
            return customerDAO;
        }
        catch (Exception e)
        {
            return null;
        }
    }
    public Iterable<CustomerDAO> getAllCustomer(){
        return customerDAORepo.findAll();
    }


}
