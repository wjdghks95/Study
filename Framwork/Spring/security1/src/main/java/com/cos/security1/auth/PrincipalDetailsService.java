package com.cos.security1.auth;

import com.cos.security1.model.Account;
import com.cos.security1.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired private AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account accountEntity = accountRepository.findByUsername(username);
        if (accountEntity != null) {
            return new PrincipalDetails(accountEntity);
        }
        return null;
    }
}
