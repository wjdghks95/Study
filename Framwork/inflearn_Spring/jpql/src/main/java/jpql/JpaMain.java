package jpql;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // EntityManager 생성
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성
        tx.begin(); // 트랜잭션 시작

        try {

            Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("회원1");
            member1.setAge(0);
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("회원2");
            member2.setAge(0);
            member2.setTeam(teamA);
            em.persist(member2);

            Member member3 = new Member();
            member3.setUsername("회원3");
            member3.setAge(0);
            member3.setTeam(teamB);
            em.persist(member3);

//            em.flush();
//            em.clear();

            //FLUSH
            int resultCount = em.createQuery("update Member m set m.age = 20")
                    .executeUpdate();

            em.clear();

            Member findMember = em.find(Member.class, member1.getId());
            System.out.println("findMember = " + findMember);

/*
            // Named 쿼리
            List<Member> resultList = em.createNamedQuery("Member.findByUsername", Member.class)
                    .setParameter("username", "회원1")
                    .getResultList();
            for (Member member : resultList) {
                System.out.println("member = " + member);
            }
*/

/*
            // 엔티티 직접사용
            String query1 = "select m from Member m where m.id = :memberId"; // 기본 키 값

            Member findMember = em.createQuery(query1, Member.class)
                    .setParameter("memberId", member1.getId())
                    .getSingleResult();

            System.out.println("findMember = " + findMember);

            String query2 = "select m from Member m where m.team = :team"; // 외래 키 값

            List<Member> members = em.createQuery(query2, Member.class)
                    .setParameter("team", teamA)
                    .getResultList();

            for (Member member : members) {
                System.out.println("member = " + member);
            }
*/

/*
            String query1 = "select m From Member m";
            String query2 = "select m From Member m join fetch m.team"; // 페치 조인

            List<Member> result = em.createQuery(query2, Member.class)
                    .getResultList();

            for (Member member : result) {
                System.out.println("member = " + member.getUsername() + ", " + member.getTeam().getName());

                // N + 1
            }

            String query3 = "select t From Team t join fetch t.members"; // 컬렉션 페치 조인
            String query4 = "select distinct t From Team t join fetch t.members"; // distinct
            List<Team> result2 = em.createQuery(query4, Team.class)
                    .getResultList();

            for (Team team : result2) {
                System.out.println("team = " + team.getName() + "|members=" + team.getMembers().size());
                for (Member member : team.getMembers()) {
                    System.out.println("-> member = " + member);
                }
            }

            String query5 = "select t From Team t";
            List<Team> result3 = em.createQuery(query5, Team.class)
                    .setFirstResult(0)
                    .setMaxResults(2)
                    .getResultList();
*/

/*
            String query1 = "select m.username From Member m"; // 상태 필드
            String query2 = "select m.team From Member m"; // 단일 값 연관 경로 - 묵시적 내부 조인
            String query3 = "select t.members From Team t"; // 컬렉션 값 연관 경로 - 묵시적 내부 조인, 탐색x
            String query4 = "select m.username From Team t join t.members m"; // 컬렉션 값 연관 경로 - 명시적 내부 조인, 탐색o

            Collection result = em.createQuery(query3, Collection.class)
                    .getResultList();
            for (Object s : result) {
                System.out.println("s = " + s);
            }
*/

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
