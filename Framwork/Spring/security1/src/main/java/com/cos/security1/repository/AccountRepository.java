package com.cos.security1.repository;

import com.cos.security1.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    public Account findByUsername(String username);
}
