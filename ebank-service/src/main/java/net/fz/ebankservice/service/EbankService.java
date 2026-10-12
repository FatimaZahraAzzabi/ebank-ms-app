package net.fz.ebankservice.service;


import net.fz.ebankservice.entities.BankAccount;
import net.fz.ebankservice.feign.CustomerRestClient;
import net.fz.ebankservice.model.Customer;
import net.fz.ebankservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class EbankService {
    @Autowired
    private BankAccountRepository accountRepository;
    @Autowired
    private CustomerRestClient customerRestClient;


    public EbankService(BankAccountRepository accountRepository) {
        this.accountRepository=accountRepository;
    }

    public List<BankAccount> getAllBankAccounts() {
        return accountRepository.findAll();
    }

    public BankAccount getBankAccountById(String id) {
        BankAccount bankAccount = accountRepository.findById(id).orElseThrow(()->new RuntimeException("Account Not found"));
        bankAccount.setCustomer(
                customerRestClient
                        .getCustomerById(bankAccount.getCustomerId()));
        return bankAccount;
    }

    public BankAccount save(BankAccount bankAccount) {
        try{
            Customer customer=customerRestClient.getCustomerById(bankAccount.getCustomerId());
            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatesAt(new Date());
            return accountRepository.save(bankAccount);
        }catch(Exception e){
          throw new RuntimeException(e.getMessage());
        }
    }


}
