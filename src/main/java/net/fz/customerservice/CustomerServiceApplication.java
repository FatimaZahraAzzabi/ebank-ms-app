package net.fz.customerservice;

import net.fz.customerservice.entities.Customer;
import net.fz.customerservice.repositories.CustomerRepository;
import net.fz.customerservice.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerService customerService) {
              return args -> {
                    List<String> names= List.of("Fatima zahra","Ziad");
                    names.forEach(name->{
                        customerService.saveCustomer(
                                Customer.builder()
                                        .name(name).email(name+"@gmail.com")
                                        .build()

                        );
                    });
              };
    }

}
