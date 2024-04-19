package com.example.dataaccess.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class MemberTemplateDao {
    private JpaTemplate jpaTemplate;

    @Autowired
    public void init(EntityManager emf) {
        this.jpaTemplate = new JpaTemplate(emf);
    }

    public List<Member> getMembers() {
        return (List<Member>) jpaTemplate.execute(new JpaCallback() {
            @Override
            public Object doInJpa(EntityManager entityManager) throws PersistenceException {
                return entityManager.createQuery("SELECT m FROM Member m").getResultList();
            }
        });

    }

    public Member getMember() {
        Member m = new Member(1, "Spring", 8.9);
        jpaTemplate.persist(m);
        return jpaTemplate.find(Member.class, 1);
    }
}
