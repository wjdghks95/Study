package com.example.dataaccess.hibernate;

import com.example.dataaccess.jpa.Member;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.sql.SQLException;

public class MemberDao {
    private HibernateTemplate hibernateTemplate;
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
        this.sessionFactory = sessionFactory;
    }

    public void addMember(Member member) {
        hibernateTemplate.save(member);
    }

    public void addMember2(Member member) {
        // getCurrentSession(): 스프링의 트랜잭션 매니저 또는 JTA의 트랜잭션에 연동되어 만들어지는 Session을 가져올 수 있다.
        // 단독으로 사용될 때 트랜잭션을 자동으로 만들어주지 못한다.
        sessionFactory.getCurrentSession().save(member);
    }

    public void count() {
        Long count = (Long) hibernateTemplate.execute(new HibernateCallback() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException, SQLException {
                return session.createQuery("SELECT count(m) FROM Member m").uniqueResult();
            }
        });
    }
}
