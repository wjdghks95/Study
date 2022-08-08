package io.security.corespringsecurity.security.service;

import io.security.corespringsecurity.domain.Account;
import io.security.corespringsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자 정의 UserDetailsService
 *  - 인증을 시도하는 사용자의 id 값을 가지고 현재 시스템 계정에 존재하는지를 검증하는 비즈니스 로직을 구현하는 곳
 *  - 회원 가입시 유저정보를 UserDetails 타입으로 만들어서 반환
 */
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = userRepository.findByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("UsernameNotFoundException");
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(account.getRole())); // 권한 추가

        AccountContext accountContext = new AccountContext(account, roles); // UserDetails 타입 객체

        return accountContext;
    }
}
