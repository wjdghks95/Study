package datajpa.repository;

import datajpa.entity.Member;

import java.util.List;

/**
 * 사용자 정의 Repository
 */
public interface MemberRepositoryCustom {
    List<Member> findMemberCustom();
}
