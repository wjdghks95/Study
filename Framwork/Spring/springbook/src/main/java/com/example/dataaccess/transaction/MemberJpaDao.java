package com.example.dataaccess.transaction;

import com.example.dataaccess.Member;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class MemberJpaDao {
    @PersistenceContext
    EntityManager entityManager;

    public void add(Member member) {
        entityManager.persist(member);
        entityManager.flush();
    }
}
