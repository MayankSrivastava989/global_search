package com.globalSearch.demo.controller;

import com.globalSearch.demo.entity.Customer;
import com.globalSearch.demo.service.CustomerService;
import com.globalSearch.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
    @GetMapping("/all")
    public List<Customer> getAll(){
        return customerService.getAllCustomer();
    }
    @GetMapping("/{id}")
    public Customer getById(@PathVariable String id){
        return customerService.getCustomerById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        customerService.deleteById(id);
    }

    @PostMapping("/addmany")
    public void addMany(@RequestParam Integer num){
        if(num==null)
            num=1;
        Customer customer=new Customer();
        Random random = new Random();
        for(int i=0;i<num;i++){
            int randomNumber = random.nextInt() + 10000000;
            customer.setCustomerId("CID"+randomNumber);
            customer.setFirstName("first"+i);
            customer.setSecondName("second"+i);
            customer.setCity("city"+i);
            customer.setStreet("street"+i);
            customer.setState("state"+i);
            customerService.addCustomer(customer);
        }
    }
}
