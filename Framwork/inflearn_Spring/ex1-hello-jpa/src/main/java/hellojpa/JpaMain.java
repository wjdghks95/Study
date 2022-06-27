package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();
            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);

            em.flush();
            em.clear();

            Parent findParent = em.find(Parent.class, parent.getId());
            findParent.getChildList().remove(0);

            /*Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Team teamB = new Team();
            team.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(team);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setTeam(teamB);
            em.persist(member2);

            em.flush();
            em.clear();

            List<Member> members = em.createQuery("select m from Member m join fetch m.team", Member.class)
                    .getResultList();*/

//            Member m = em.find(Member.class, member1.getId());

            /*System.out.println("m = " + m.getTeam().getClass());
            System.out.println("===============");
            System.out.println(m.getTeam().getName());
            System.out.println("===============");*/

            /*Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " + refMember.getClass()); // Proxy

            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember)); // 프록시 초기화 여부 확인
            Hibernate.initialize(refMember);*/

//            em.detach(refMember);
//            em.close();
//            em.clear();

//            refMember.getUsername();

//            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember));

            /*Member refMember = em.getReference(Member.class, member1.getId()); // Proxy
            System.out.println("m1 = " + refMember.getClass());

            Member findMember = em.find(Member.class, member1.getId()); // Member, 프록시 먼저 조회시 프록시 반환
            System.out.println("reference = " + findMember.getClass());

            System.out.println("a == a: " + (refMember == findMember));*/

            /*Member m1 = em.find(Member.class, member1.getId());
            System.out.println("m1 = " + m1.getClass());

            Member reference = em.getReference(Member.class, member1.getId()); // 영속성 컨텍스트에 엔티티가 있으므로 실제 엔티티 반환
            System.out.println("reference = " + reference.getClass());

            System.out.println("a == a: " + (m1 == reference));*/

            /*Member m1 = em.find(Member.class, member1.getId());
            Member m2 = em.getReference(Member.class, member2.getId());

            logic(m1, m2);*/

//            Member findMember = em.find(Member.class, member1.getId());
/*            Member findMember = em.getReference(Member.class, member1.getId());
            System.out.println("findMember = " + findMember.getClass());
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.username = " + findMember.getUsername()); // 초기화 요청 (딱 한번만 초기화)
            System.out.println("findMember.username = " + findMember.getUsername()); */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2: " + (m1 instanceof Member));
        System.out.println("m1 == m2: " + (m2 instanceof Member));
    }
}
