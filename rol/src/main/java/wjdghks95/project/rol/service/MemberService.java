package wjdghks95.project.rol.service;

import wjdghks95.project.rol.domain.dto.MemberDto;
import wjdghks95.project.rol.domain.entity.Member;

public interface MemberService {

    public Long join(MemberDto memberDto);
}
