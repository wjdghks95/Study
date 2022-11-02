package wjdghks95.project.rol.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import wjdghks95.project.rol.domain.dto.MemberDto;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.domain.entity.Review;
import wjdghks95.project.rol.repository.MemberRepository;
import wjdghks95.project.rol.repository.ReviewRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public Long join(MemberDto memberDto) {

        Member member = Member.builder()
                .email(memberDto.getEmail())
                .password(passwordEncoder.encode(memberDto.getPassword()))
                .phone(memberDto.getPhone())
                .name(memberDto.getName())
                .nickname(memberDto.getNickname())
                .zipcode(memberDto.getZipcode())
                .address(memberDto.getAddress())
                .detailAddress(memberDto.getDetailAddress())
                .profileImage(null)
                .role("ROLE_USER")
                .build();

        memberRepository.save(member);
        return member.getId();
    }

    @Transactional
    public void withdrawal(Long id) {
        Member member = memberRepository.findById(id).orElseThrow();
        memberRepository.delete(member);
    }
}
