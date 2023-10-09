package com.globalSearch.demo.controller;

import com.globalSearch.demo.entity.Customer;
import com.globalSearch.demo.entity.Order;
import com.globalSearch.demo.service.CustomerService;
import com.globalSearch.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private CustomerService customerService;
    @PostMapping("/add")
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);
    }

    @GetMapping("/{id}")
    public Order getById(@PathVariable String id)
    {
        return orderService.getOrderById(id);
    }

    @GetMapping("/all")
    public List<Order> getAll(){
        return orderService.getAllOrder();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        orderService.deleteOrderById(id);
    }
    @PostMapping("/addmany")
    public void addManyOrder(@RequestParam Integer num, @RequestParam String customerId){
        if(num==null)
            num=1;
        Order order=new Order();
        Random random = new Random();

        for(int i=0;i<num;i++)
        {
            int randomNumber = random.nextInt(899999999) + 100000000;
            order.setOrderId("ORD"+randomNumber);
            order.setOrderName("order"+i);
            LocalDateTime currentDateTime = LocalDateTime.now();
            order.setOrderDate(currentDateTime);
            order.setOrderDescription("order has been placed on "+currentDateTime.toString());
            int randomNumber2=random.nextInt(1000000);
            order.setAmount((long) randomNumber2);
            order.setClientId("SHP"+randomNumber);
            order.setSuperClientId("DIS"+randomNumber);
            if(customerId==null)
            {
                Customer customer=new Customer();
                int randomNumber3 = random.nextInt() + 10000000;
                customerId="CID"+randomNumber3;
                order.setCustomerId(customerId);
                customer.setCustomerId("CID"+randomNumber);
                customer.setFirstName("first"+i);
                customer.setSecondName("second"+i);
                customer.setCity("city"+i);
                customer.setStreet("street"+i);
                customer.setState("state"+i);
                customerService.addCustomer(customer);
            }
            else
                order.setCustomerId(customerId);
            orderService.addOrder(order);
        }
    }
}
