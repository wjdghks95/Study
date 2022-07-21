package hello.jpa.jpql;

import javax.persistence.*;
import java.util.List;

/**
 * JPQL
 */
public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager(); // EntityManager 생성
        EntityTransaction tx = em.getTransaction(); // 트랜잭션 생성

        tx.begin(); // 트랜잭션 시작
        try {
            /**
             * 쿼리
             */
            Query query = em.createQuery("select m from Member m"); // 반환타입이 명확하지 않음

            // TypeQuery
            TypedQuery<Member> typedQuery = em.createQuery("select m from Member m", Member.class); // 반환타입이 명확

            Member result = typedQuery.getSingleResult(); // 결과가 한개
            List<Member> resultList = typedQuery.getResultList(); // 결과가 한개 이상
            for (Member member : resultList) {
                System.out.println("member = " + member);
            }

            // 파라미터 바인딩
            Member memberKim = em.createQuery("select m from Member m where m.username = :username", Member.class)
                    .setParameter("username", "KIM")
                    .getSingleResult();

            /**
             * 프로젝션
             */
            // 엔티티 프로젝션
            em.createQuery("select m From Member m", Member.class);
            em.createQuery("select t From Member m join m.Team t", Team.class);

            // 임베디드 타입 프로젝션
            em.createQuery("select m.address From Member m", Address.class);

            // 스칼라 타입 프로젝션
            List<String> username = em.createQuery("select username from Member m", String.class).getResultList();

            // 여러 값 조회 Object[] 타입
            List<Object[]> objectArr = em.createQuery("select m.name, m.age From Member m").getResultList();
            for (Object[] row : objectArr) {
                String name = (String) row[0];
                Integer age = (Integer) row[1];
            }

            // 여러 값 조회 DTO 타입
            List<MemberDTO> memberDto = em.createQuery("select new hello.jpa.jpql.MemberDTO(m.name, m.age) from Member m", MemberDTO.class).getResultList();
            MemberDTO memberDTO = memberDto.get(0);

            /**
             * 페이징
             */
            em.createQuery("select m from Member m order by m.age desc", Member.class)
                    .setFirstResult(1) // 조회 시작 위치
                    .setMaxResults(10) // 조회할 데이터 수
                    .getResultList();

            /**
             * 조인
             */
            // [inner]: 내부 조인
            em.createQuery("select m from Member m inner join m.team t", Member.class);

            // left|right [outer]: 외부 조인
            em.createQuery("select m from Member m left join m.team t", Member.class);

            // 컬렉션 조인
            em.createQuery("select t, m from Team t left join t.members m", Member.class);

            // 세타 조인 -  WHERE 절을 사용, 관계없는 엔티티도 조인
            em.createQuery("select m from Member m, Team t where m.name = t.name", Member.class);

            // on: 조인 대상 필터링
            em.createQuery("select m from Member m left join m.team t on t.name = name", Member.class);

            // 연관관계 없는 엔티티 외부 조인
            em.createQuery("select m from Member m left join Team t on m.name = t.name", Member.class);

            /**
             * 서브쿼리
             */
            em.createQuery("select (select avg(m1.age) from Member m1) as avgAge from Member m join Team t on m.name = t.name", Member.class);

            /**
             * 패치 조인
             *  - 가급적 fetch 조인 대상에 별칭 부여 X
             *  - 둘 이상의 컬렉션은 fetch 조인 불가능
             *  - 컬렉션을 fetch 조인하면 페이징 API 사용 불가능
             */
            em.createQuery("select m from Member m join fetch m.team"); // fetch 조인, 지연 로딩 X
            em.createQuery("select t from Team t join fetch t.members"); // 컬렉션 fetch 조인 -> 중복 발생
            em.createQuery("select distinct t From Team t join fetch t.members"); // distinct: 엔티티 중복 제거

            /**
             * 다형성 쿼리
             */
            // Item 의 자식도 함께 조회
            em.createQuery("select i from Item i").getResultList();

            // type: 특정 자식 타입으로 한정
            em.createQuery("select i from Item i where type(i) IN (Book, Movie)").getResultList();

            // treat: 상속 구조에서 부모 타입을 특정 자식 타입으로 다룰 때 사용
            em.createQuery("select i from Item i where treat(i as Book).author = 'kim'").getResultList();

            /**
             * Named 쿼리
             * @NamedQuery
             */
            em.createNamedQuery("Member.findByUsername", Member.class)
                    .setParameter("username", "회원1")
                    .getResultList();

            /**
             * 벌크 연산
             * 벌크 연산은 영속성 컨텍스트를 무시하고 데이터베이스에 직접 쿼리, Flush
             * 벌크 연산을 먼저 실행하거나 벌크 연산 수행 후 영속성 컨텍스트 초기화해야 함
             */
            em.createQuery("update Member m set m.age = 20").executeUpdate();
            em.clear();

            /**
             * 사용자 정의 호출 함수
             * 하이버네이트 구현체를 사용
             * H2Dialect 를 구현하여 hibernate.dialect 에 해당 방언 등록
             */
            em.createQuery("select function('group_concat', m.name) From Member m");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
