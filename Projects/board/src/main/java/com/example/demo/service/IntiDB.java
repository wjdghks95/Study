package com.example.demo.service;

import com.example.demo.domain.entity.Board;
import com.example.demo.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class IntiDB {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.dbInit();
    }

}

@Service
@Transactional
@RequiredArgsConstructor
class InitService {

    private final EntityManager em;
    private final PasswordEncoder passwordEncoder;

    public void dbInit() {

        Member admin = new Member("admin", passwordEncoder.encode("1234"), "admin@test.com", null);
        Member manager = new Member("manager", passwordEncoder.encode("1234"), "manager@test.com", null);
        Member user = new Member("user", passwordEncoder.encode("1234"), "user@test.com", null);

        em.persist(admin);
        em.persist(manager);
        em.persist(user);

        for (int i = 0; i < 100; i++) {
            em.persist(new Board("타이틀"+i, "콘텐츠"+i, "user"));
        }

    }
}
