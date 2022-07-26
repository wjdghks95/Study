package datajpa.repository;

import datajpa.entity.Member;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberProjection {

    List<Member> findByNativeProjection(Pageable pageable);
}
