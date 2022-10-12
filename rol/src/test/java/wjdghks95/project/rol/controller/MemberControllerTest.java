package wjdghks95.project.rol.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import wjdghks95.project.rol.domain.dto.MemberDto;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.repository.MemberRepository;

import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {

    @Autowired private MockMvc mockMvc;

    @Autowired MemberRepository memberRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    String url = "/signUp";


    @Test
    @DisplayName("회원가입 폼")
    void getSignUp() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(url))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 정상")
    void signUp_success() throws Exception {

        MemberDto memberDto = createMemberDto("01012345678", "test@test.com", "asdf1234!", "테스트", "테스터", "12345", "테스트 주소", "테스트 상세주소", "true");

        MultiValueMap<String, String> params = setParams(memberDto);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                .params(params)
                .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 아이디, 닉네임 중복")
    void signUp_duplicate_id_and_nickname() throws Exception {
        Member member = createMember("01012345678", "test@test.com", "asdf1234!", "테스트", "테스터", "12345", "테스트 주소", "테스트 상세주소");
        memberRepository.save(member);

        MemberDto memberDto = createMemberDto("01012345678", "test@test.com", "asdf1234!", "테스트", "테스터", "12345", "테스트 주소", "테스트 상세주소", "true");

        MultiValueMap<String, String> params = setParams(memberDto);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .params(params)
                        .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrors("memberDto", "email"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrors("memberDto", "nickname"))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    @DisplayName("회원가입 휴대폰 인증 x, 비밀번호 일치 x")
    void signUp_authCheck() throws Exception {
        MemberDto memberDto = createMemberDto("01012345678", "test@test.com", "asdf1234!", "테스트", "테스터", "12345", "테스트 주소", "테스트 상세주소", "false");

        MultiValueMap<String, String> params = setParams(memberDto);

        mockMvc.perform(MockMvcRequestBuilders.post(url)
                        .params(params)
                        .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrors("memberDto", "phoneCheck"))
                .andExpect(MockMvcResultMatchers.model().attributeHasFieldErrors("memberDto", "passwordCheck"))
                .andDo(MockMvcResultHandlers.print());
    }

    private MultiValueMap<String, String> setParams(MemberDto memberDto) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        Map<String, String> maps = objectMapper.convertValue(memberDto, new TypeReference<Map<String, String>>() {});
        params.setAll(maps);
        return params;
    }

    private MemberDto createMemberDto(String phone, String email, String password, String name, String nickname, String zipcode, String address, String detailAddress, String aTrue) {
        return MemberDto.builder()
                .phone(phone)
                .email(email)
                .password(password)
                .name(name)
                .nickname(nickname)
                .zipcode(zipcode)
                .address(address)
                .detailAddress(detailAddress)
                .phoneCheck(aTrue)
                .passwordCheck(aTrue)
                .build();
    }

    private Member createMember(String phone, String email, String password, String name, String nickname, String zipcode, String address, String detailAddress) {
        return Member.builder()
                .phone(phone)
                .email(email)
                .password(password)
                .name(name)
                .nickname(nickname)
                .zipcode(zipcode)
                .address(address)
                .detailAddress(detailAddress)
                .role("USER")
                .build();
    }
}