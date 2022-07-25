package datajpa.repository;

import org.springframework.data.domain.Pageable;

public interface MemberProjection {

    findByNativeProjection(Pageable pageable);
}
