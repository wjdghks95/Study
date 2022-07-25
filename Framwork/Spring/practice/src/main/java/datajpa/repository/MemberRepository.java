package datajpa.repository;

import datajpa.dto.MemberDto;
import datajpa.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA Repository
 */
public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

    /**
     * 메소드 이름으로 쿼리 생성
     */
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    /**
     * 스프링 데이터 JPA로 NamedQuery 사용
     * @NamedQuery
     */
    @Query(name = "Member.findByUsername")
    List<Member> findV1ByUsername(@Param("username") String username);

    /**
     * 스프링 데이터 JPA로 NamedQuery 호출
     * @NamedQuery
     * JpaRepository 인터페이스에 정의한 도메인 클래스 + . + 메서드 이름으로 Named 쿼리를 찾아 실행
     */
    List<Member> findV2ByUsername(@Param("username") String username);

    /**
     * @Query
     * Repository 메소드에 쿼리 정의
     */
    @Query("select m from Member m where m.username= :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    /**
     * @Query, 값, DTO 조회하기
     */
    //단순히 값 하나를 조회
    @Query("select m.username from Member m")
    List<String> findUsernameList();

    //DTO로 직접 조회
    @Query("select new datajpa.dto.MemberDto(m.id, m.username, t.name) " +
            "from Member m join m.team t")
    List<MemberDto> findMemberDto();

    /**
     * 파라미터 바인딩
     * @Param
     */
    @Query("select m from Member m where m.username = :name")
    Member findMembers(@Param("name") String username);

    // 컬렉션 파라미터 바인딩
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") List<String> names);

    /*
     * 반환 타입
     *  - List<Member> //컬렉션
     *      -> 결과 없음: 빈 컬렉션 반환
     *  - Member //단건
     *      -> 결과 없음: null 반환
     *      -> 결과가 2건 이상: javax.persistence.NonUniqueResultException 예외 발생
     *  - Optional<Member> //단건 Optional
     */

    /**
     * 스프링 데이터 JPA 페이징과 정렬
     * 예시
     *  - Page<Member> findByUsername(String name, Pageable pageable); -> count 쿼리 사용
     *  - Slice<Member> findByUsername(String name, Pageable pageable); -> count 쿼리 사용 안함
     *  - List<Member> findByUsername(String name, Pageable pageable); -> count 쿼리 사용 안함
     *  - List<Member> findByUsername(String name, Sort sort);
     *
     *  pageable ->  PageRequest.of(page, size, sort);
     */
    Page<Member> findByAge(int age, Pageable pageable);

    /**
     * count 쿼리 분리
     * countQuery
     */
    @Query(value = "select m from Member m",
            countQuery = "select count(m.username) from Member m")
    Page<Member> findMemberAllCountBy(Pageable pageable);

    /**
     * 스프링 데이터 JPA를 사용한 벌크성 수정 쿼리
     * @Modifying
     */
    @Modifying(clearAutomatically = true)
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

    /**
     * JPQL 페치 조인
     */
    @Query("select m from Member m left join fetch m.team")
    List<Member> findMemberFetchJoin();

    /**
     * @EntityGraph
     * 페치 조인(FETCH JOIN)의 간편 버전
     * LEFT OUTER JOIN 사용
     */
    //공통 메서드 오버라이드
    @Override
    @EntityGraph(attributePaths = {"team"})
    List<Member> findAll();

    //JPQL + 엔티티 그래프
    @EntityGraph(attributePaths = {"team"})
    @Query("select m from Member m")
    List<Member> findMemberEntityGraph();

    //메서드 이름으로 조회하는 쿼리에서 특히 편리
    @EntityGraph(attributePaths = {"team"})
    List<Member> findEntityGraphByUsername(String username);

    /**
     * @NamedEntityGraph
     */
    @EntityGraph("Member.all")
    @Query("select m from Member m")
    List<Member> findMemberNamedEntityGraph();

    /**
     * JPA Hint
     * @QueryHints
     */
    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    Member findReadOnlyByUsername(String username);

    @QueryHints(value = {@QueryHint(name = "org.hibernate.readOnly", value = "true")}, forCounting = true)
    Page<Member> findByUsername(String name, Pageable pageable);

    /**
     * JPA Lock
     * @Lock
     */
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Member> findByUsername(String name);

    /**
     * 스프링 데이터 JPA 기반 네이티브 쿼리
     */
    @Query(value = "select * from member where username = ?", nativeQuery = true)
    Member findByNativeQuery(String username);
}
