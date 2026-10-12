package net.fz.ebankservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.*;
import net.fz.ebankservice.model.Customer;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Date createsAt;
    private double balance;
    private String type;
    private long customerId;
    @Transient // n'est pas dans la base de données
    private Customer customer;



}
