package hello.jpa.hellojpa;


import hello.jpa.hellojpa.cascade.Child;
import hello.jpa.hellojpa.cascade.Parent;
import hello.jpa.hellojpa.valuetype.Address;
import hello.jpa.hellojpa.valuetype.Zipcode;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
/*
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
*/

            /**
             *  - 영속성 컨텍스트의 이점
             */
/*
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
*/

            /**
             * 엔티티 매핑
             * 연관관계 매핑
             */
/*
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("==============");
            for (Member m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("==============");
*/
            /**
             * 프록시와 연관관계
             */
/*
            Member member = new Member();
            member.setUsername("member1");

            // 실제 엔티티 먼저 조회 시 영속성 컨텍스트에 엔티티가 있으므로 이후 프록시를 조회해도 실제 엔티티 반환
            // 프록시가 먼저 조회 시 이후 실제 엔티티 객체를 조회해도 프록시 반환
            Member findMember = em.find(Member.class, member.getId()); // 실제 엔티티 객체 조회
            System.out.println("m1 = " + findMember.getClass());

            Member refMember = em.getReference(Member.class, member.getId()); // 프록시 엔티티 객체 조회
            System.out.println("m1 = " + refMember.getClass());

            System.out.println("isLoaded = " + emf.getPersistenceUnitUtil().isLoaded(refMember)); // 프록시 초기화 여부 확인
            Hibernate.initialize(refMember); // 프록시 강제 초기화

            logic(findMember, refMember); // 프록시 객체 타입 체크시 instanceof 사용

            // 준영속 상태일 때, 프록시 초기화 시 LazyInitializationException 예외 발생
            em.detach(refMember);
            refMember.getUsername(); // 초기화 요청(처음 사용시 딱 한 번만 초기화), 실제 엔티티에 접근
*/

            /**
             * 영속화
             */
/*
            Child child1 = new Child();
            Child child2 = new Child();
            Parent parent = new Parent();

            child1.setParent(parent); // 연관관계 추가
            child2.setParent(parent); // 연관관계 추가
            parent.getChildren().add(child1);
            parent.getChildren().add(child2);

            em.persist(parent); // 부모 엔티티를 영속화할 때 자식 엔티티도 같이 영속화
*/

            /**
             * 고아 객체
             */
/*
            Parent parent1 = em.find(Parent.class, parent.getId());
            parent1.getChildren().remove(0); // 첫 번째 자식 엔티티를 컬렉션에서 제거
            parent1.getChildren().clear(); // 모든 자식 엔티티 제거
*/

            /**
             * 값 타입
             */
            Member member = new Member();

            // 임베디드 값 타입
            member.setHomeAddress(new Address("통영", "몽동해수욕장", "660-123", new Zipcode()));

            // 기본값 타입 컬렉션
            member.getFavoriteFoods().add("짬뽕");
            member.getFavoriteFoods().add("짜장");
            member.getFavoriteFoods().add("탕수육");

            // 임베디드 값 타입 컬렉션
            member.getAddressHistory().add(new Address("서울", "강남", "123-123", new Zipcode()));
            member.getAddressHistory().add(new Address("서울", "강북", "000-000", new Zipcode()));

            // member 엔티티만 영속화하면 값 타입도 함께 저장
            em.persist(member);

            tx.commit(); // 커밋
        }catch(Exception e){
            tx.rollback(); // 롤백
        }finally {
            em.close(); // EntityManager 종료
        }
        emf.close(); // EntityManagerFactory 종료
    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2: " + (m1 instanceof Member));
        System.out.println("m1 == m2: " + (m2 instanceof Member));
    }
}
