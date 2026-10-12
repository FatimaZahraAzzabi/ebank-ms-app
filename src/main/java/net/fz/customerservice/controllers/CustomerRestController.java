package net.fz.customerservice.controllers;

import jakarta.ws.rs.Path;
import net.fz.customerservice.CustomerServiceApplication;
import net.fz.customerservice.entities.Customer;
import net.fz.customerservice.repositories.CustomerRepository;
import net.fz.customerservice.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }

    @PostMapping("/customers")
    public Customer saveCustomer(Customer customer) {
        return customerService.saveCustomer(customer);
    }

}
