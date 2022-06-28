package jpql;

import javax.persistence.*;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager(); // EntityManager 생성
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성
        tx.begin(); // 트랜잭션 시작

        try {

/*
            // 페이징
            for (int i = 0; i < 100; i++) {
                Member member = new Member();
                member.setUsername("member" + i);
                member.setAge(i);
                em.persist(member);
            }
*/

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("관리자1");
            member.setAge(10);
            member.setTeam(team);
            member.setType(MemberType.ADMIN);
            em.persist(member);

            Member member2 = new Member();
            member2.setUsername("관리자2");
            em.persist(member2);

            em.flush();
            em.clear();

            String query1 = "select concat('a', 'b') From Member m";
            String query2 = "select substring(m.username, 2, 3) From Member m";
            String query3 = "select locate('de', 'abcdefg') From Member m";
            String query4 = "select size(t.members) From Team t";
            String query5 = "select function('group_concat', m.username) From Member m";

            List<String> result = em.createQuery(query5, String.class)
                    .getResultList();
            for (String s : result) {
                System.out.println("s = " + s);
            }

            List<Integer> result2 = em.createQuery(query3, Integer.class)
                    .getResultList();
            for (Integer s : result2) {
                System.out.println("s = " + s);
            }
/*
            // 조건식
            String query1 = "select " +
                                "case when m.age <= 10 then '학생요금' " +
                                "     when m.age >= 60 then '경로요금' " +
                                "     else '일반요금' " +
                                "end " +
                            "from Member m";
            List<String> result = em.createQuery(query1, String.class)
                    .getResultList();
            for (String s : result) {
                System.out.println("s = " + s);
            }

            String query2 = "select coalesce(m.username, '이름 없는 회원') from Member m ";
            List<String> result2 = em.createQuery(query2, String.class)
                    .getResultList();
            for (String s : result2) {
                System.out.println("s = " + s);
            }

            String query3 = "select nullif(m.username, '관리자') from Member m ";
            List<String> result3 = em.createQuery(query3, String.class)
                    .getResultList();
            for (String s : result3) {
                System.out.println("s = " + s);
            }
*/

/*
            // 타입 표현
            String query = "select m.username, 'HELLO', TRUE from Member m " +
                            "where m.type = :userType";
            List<Object[]> result = em.createQuery(query)
                    .setParameter("userType", MemberType.ADMIN)
                    .getResultList();

            for (Object[] objects : result) {
                System.out.println("objects = " + objects[0]);
                System.out.println("objects = " + objects[1]);
                System.out.println("objects = " + objects[2]);
            }
*/

/*
            // 조인
            em.createQuery("select m from Member m inner join m.team t", Member.class).getResultList();
            em.createQuery("select m from Member m left join m.team t", Member.class).getResultList();
            em.createQuery("select m from Member m, Team t where m.username = t.name", Member.class).getResultList();
            em.createQuery("select m from Member m left join m.team t on t.name = teamA", Member.class).getResultList();
*/

/*
            // 페이징
            List<Member> result = em.createQuery("select m from Member m order by m.age desc", Member.class)
                    .setFirstResult(1)
                    .setMaxResults(10)
                    .getResultList();

            System.out.println("result.size() = " + result.size());
            for (Member member1 : result) {
                System.out.println("member1 = " + member1);
            }
*/

/*
            // 프로젝션
            em.createQuery("select t From Member m join m.team t", Team.class)
                    .getResultList();

            em.createQuery("select o.address From Order o", Address.class)
                    .getResultList();

            em.createQuery("select distinct m.username, m.age From Member m", Member.class)
                    .getResultList();
*/

//            List resultList = em.createQuery("select m.username, m.age From Member m").getResultList();

//            List<Object[]> resultList = em.createQuery("select m.username, m.age From Member m").getResultList();


//            List<MemberDTO> result = em.createQuery("select new jpql.MemberDTO(m.username, m.age) From Member m", MemberDTO.class).getResultList();

/*
            Object o = resultList.get(0);
            Object[] result = (Object[]) o;
            Object[] result = resultList.get(0);
            System.out.println("username = " + result[0]);
            System.out.println("age = " + result[1]);
*/

/*
            MemberDTO memberDTO = result.get(0);
            System.out.println("username = " + memberDTO.getUsername());
            System.out.println("age = " + memberDTO.getAge());
*/

/*
            // 기본문법 및 쿼리 API
            TypedQuery<Member> query1 = em.createQuery("select m From Member m where m.id=1", Member.class);
            TypedQuery<String> query2 = em.createQuery("select m.username From Member m", String.class);
            Query query3 = em.createQuery("select m.username, m.age From Member m");

            List<Member> resultList = query1.getResultList();
            for (Member member1 : resultList) {
                System.out.println("member1 = " + member1);
            }

            Member result = em.createQuery("select m From Member m where m.username = :username", Member.class)
                    .setParameter("username", "member1")
                    .getSingleResult();
            System.out.println("singleResult = " + result.getUsername());
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
