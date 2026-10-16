package net.fz.customerservice.service;

import net.fz.customerservice.entities.Customer;
import net.fz.customerservice.repositories.CustomerRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @McpTool(description="Get All customers")
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    @McpTool(description = "Recherche un client par son identifiant numérique. À appeler uniquement si l'utilisateur demande un client précis et fournit son ID.")
    public Customer findCustomerById(
            @McpToolParam(description = "ID numérique du client, par exemple 1 ou 2")
            Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer Not Found"));
    }
    @McpTool(description="Save a new customers")
    public Customer saveCustomer(@McpToolParam(description ="The customer to save (nom , email)")Customer customer) {
        return customerRepository.save(customer);
    }
}
