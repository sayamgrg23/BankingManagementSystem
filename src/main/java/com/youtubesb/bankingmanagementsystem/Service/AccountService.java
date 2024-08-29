package com.youtubesb.bankingmanagementsystem.Service;

import com.youtubesb.bankingmanagementsystem.Entities.AccountEntity;
import com.youtubesb.bankingmanagementsystem.Repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public AccountEntity createAccount(AccountEntity account) {
        return accountRepository.save(account);
    }

    public Optional<AccountEntity> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public List<AccountEntity> getAllAccount() {
        return accountRepository.findAll();
    }

    public AccountEntity deposit(Long id, double amount) {
        AccountEntity account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public AccountEntity withdraw(Long id, double amount) {
        AccountEntity account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }
}
