package querydsl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import querydsl.dto.MemberSearchCondition;
import querydsl.dto.MemberTeamDto;

import java.util.List;

/**
 * 사용자 정의 Repository
 */
public interface MemberRepositoryCustom {

    List<MemberTeamDto> search(MemberSearchCondition condition);

    Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable);

    Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable pageable);
}
