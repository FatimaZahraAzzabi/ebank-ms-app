package net.fz.ebankservice.service;

import net.fz.ebankservice.entities.BankAccount;
import net.fz.ebankservice.feign.CustomerRestClient;
import net.fz.ebankservice.model.Customer;
import net.fz.ebankservice.repositories.BankAccountRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.ai.mcp.annotation.McpToolParam;
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
        this.accountRepository = accountRepository;
    }

    @McpTool(description = "Get all bank accounts")
    public List<BankAccount> getAllBankAccounts() {
        return accountRepository.findAll();
    }

    @McpTool(description = "Search for a bank account by its unique ID")
    public BankAccount getBankAccountById(
            @McpToolParam(description = "The unique ID of the bank account")
            String id) {

        BankAccount bankAccount = accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account Not Found"));

        bankAccount.setCustomer(
                customerRestClient.getCustomerById(bankAccount.getCustomerId())
        );

        return bankAccount;
    }

    @McpTool(description = "Create and save a new bank account")
    public BankAccount save(
            @McpToolParam(description = "The bank account details, including type, balance, and customer ID")
            BankAccount bankAccount) {

        try {
            Customer customer = customerRestClient.getCustomerById(
                    bankAccount.getCustomerId()
            );

            bankAccount.setId(UUID.randomUUID().toString());
            bankAccount.setCreatesAt(new Date());

            return accountRepository.save(bankAccount);

        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}