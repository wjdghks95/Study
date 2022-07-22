package hello.jpa.hellojpa;

import hello.jpa.hellojpa.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * 엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에서 공유
 * 엔티티 매니저는 쓰레드간에 공유X
 * JPA 의 모든 데이터 변경은 트랜잭션 안에서 실행
 */

public class JpaMain {

    public static void main(String[] args) {
        // 설정 정보 조회, EntityManagerFactory 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        // EntityManager 생성
        EntityManager em = emf.createEntityManager();

        // 트랜잭션 생성
        EntityTransaction tx = em.getTransaction();

        // 트랜잭션 시작
        tx.begin();

        try{

            /**
             * 영속성 컨텍스트
             *  - 엔티티 생명주기
             */
            // 객체를 생성한 상태(비영속)
            Member member = new Member();
            member.setId("1L");
            member.setUserName("memberA");

            // 객체를 저장한 상태(영속) -> 1차 캐시에 저장
            em.persist(member);

            // 영속성 컨텍스트에서 삭제 (준영속)
            em.detach(member);

            // db에서 삭제 (삭제)
            em.remove(member);

            /**
             *  - 영속성 컨텍스트의 이점
             */
            //1. 1차 캐시에서 조회, 캐시에 없는 경우 데이터베이스에서 조회
            Member findMember = em.find(Member.class,"1L");

            //2. 동일성 보장
            Member a = em.find(Member.class , "1L");
            Member b = em.find(Member.class , "1L");
            System.out.println(a == b); //동일성 비교 true

            //3. 트랜잭션을 지원하는 쓰기 지연
            Member member1 = new Member("150L", "A");
            Member member2 = new Member("160L", "B");

            em.persist(member1);
            em.persist(member2);
            // INSERT SQL을 데이터베이스에 보내지 않음, 커밋하는 순간 SQL을 보냄

            //4. 변경 감지
            Member findMember2 = em.find(Member.class, "1L"); // 영속 엔티티 조회
            findMember2.setUserName("memberB"); // 영속 엔티티 데이터 수정

            // 영속성 컨텍스트의 변경 내용을 데이터베이스에 반영, 커밋X
            em.flush();
            // 영속성 컨텍스트를 완전히 초기화
            em.clear();

            tx.commit(); // 커밋
        }catch(Exception e){
            tx.rollback(); // 롤백
        }finally {
            em.close(); // EntityManager 종료
        }
        emf.close(); // EntityManagerFactory 종료
    }
}
