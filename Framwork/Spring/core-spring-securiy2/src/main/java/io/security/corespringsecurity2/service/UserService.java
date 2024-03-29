package io.security.corespringsecurity2.service;

import io.security.corespringsecurity2.domain.dto.AccountDto;
import io.security.corespringsecurity2.domain.entity.Account;

import java.util.List;

public interface UserService {

    void createUser(Account account);

    void modifyUser(AccountDto accountDto);

    List<Account> getUsers();

    AccountDto getUser(Long id);

    void deleteUser(Long idx);

    void order();
}
