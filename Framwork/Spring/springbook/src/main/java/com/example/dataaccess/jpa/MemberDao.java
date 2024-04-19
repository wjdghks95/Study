package com.example.dataaccess.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class MemberDao {
    // EntityManagerFactory 주입
//    @Autowired
//    @PersistenceUnit
//    EntityManagerFactory emf;

    // EntityManager 주입
    @PersistenceContext
//    @PersistenceContext(type = PersistenceContextType.EXTENDED) // 확장된 스코프를 갖는 EntityManager
    EntityManager em;

    public void addMember(Member member) {
//        EntityManager em = emf.createEntityManager();
        em.persist(member);
    }
}
