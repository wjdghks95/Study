package datajpa.web;

import datajpa.entity.Member;
import datajpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

/*
    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id).get();
        return member.getUsername();
    }
*/

    /**
     * 도메인 클래스 컨버터 사용
     * HTTP 파라미터로 넘어온 엔티티의 아이디로 엔티티 객체를 찾아서 바인딩
     * 단순 조회용으로만 사용
     */
    @GetMapping("/members/{id}")
    public String findMember(@PathVariable("id") Member member) {
        return member.getUsername();
    }

    /**
     * 페이징과 정렬
     * Pageable
     */
    @GetMapping("/members")
    public Page<MemberDto> listV1(Pageable pageable) {
        return memberRepository.findAll(pageable).map(MemberDto::new);
    }

    /**
     * 페이징 정보 개별 설정
     * @PageableDefault
     */
    @RequestMapping(value = "/members_page", method = RequestMethod.GET)
    public Page<MemberDto> listV2(@PageableDefault(size = 12, sort = "username", direction = Sort.Direction.DESC) Pageable pageable) {
        return memberRepository.findAll(pageable).map(MemberDto::new);
    }

    /**
     * 접두사
     * 페이징 정보가 둘 이상이면 접두사로 구분
     * @Qualifier
     */
    public Page<MemberDto> listV3(
            @Qualifier("member") Pageable memberPageable,
            @Qualifier("order") Pageable orderPageable) {
        return memberRepository.findAll(memberPageable).map(MemberDto::new);
    }
}
