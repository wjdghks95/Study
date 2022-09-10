package com.cos.security1.config;

import com.cos.security1.model.Account;
import com.cos.security1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class InitAccount {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        Account user = new Account();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("1234"));
        user.setEmail("user@test.com");
        user.setRole("ROLE_USER");

        Account manager = new Account();
        manager.setUsername("manager");
        manager.setPassword(passwordEncoder.encode("1234"));
        manager.setEmail("manager@test.com");
        manager.setRole("ROLE_MANAGER");

        Account admin = new Account();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("1234"));
        admin.setEmail("admin@test.com");
        admin.setRole("ROLE_ADMIN");

        accountRepository.save(user);
        accountRepository.save(manager);
        accountRepository.save(admin);
    }
}
