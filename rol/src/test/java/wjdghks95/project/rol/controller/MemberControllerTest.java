package wjdghks95.project.rol.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
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
import wjdghks95.project.rol.service.MemberService;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MemberControllerTest {

    @Autowired MockMvc mockMvc;

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    String url = "/signUp";


    @Test
    @DisplayName("회원가입 폼 진입")
    void getSignUp() throws Exception {
        mockMvc.perform(get(url))
                .andExpect(model().attributeExists("memberDto"))
                .andExpect(view().name("signUpForm"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("회원가입 처리: 입력값 정상")
    void signUp_success() throws Exception {

        MemberDto memberDto = createMemberDto("01012345678", "test@test.com", "asdf1234!", "테스트", "테스터", "12345", "테스트 주소", "테스트 상세주소", "true");

        MultiValueMap<String, String> params = setParams(memberDto);

        mockMvc.perform(post(url)
                .params(params)
                .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(view().name("redirect:/"))
                .andExpect(status().is3xxRedirection())
                .andDo(print());
        assertTrue(memberRepository.existsByEmail("test@test.com"));
        Member member = memberRepository.findByEmail("test@test.com").get();
        assertNotEquals(member.getPassword(), "asdf1234!");
    }

    @Test
    @DisplayName("회원가입 처리: 입력값 오류")
    void signUp_fail() throws Exception {
        MemberDto memberDto = createMemberDto("010123456780", "testtest.com", "asdf1234", "", "a", "", "", "", "");

        MultiValueMap<String, String> params = setParams(memberDto);

        mockMvc.perform(post(url)
                        .params(params)
                        .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(model().attributeHasFieldErrors("memberDto", "phone"))
                .andExpect(model().attributeHasFieldErrors("memberDto", "email"))
                .andExpect(model().attributeHasFieldErrors("memberDto", "password"))
                .andExpect(model().attributeHasFieldErrors("memberDto", "name"))
                .andExpect(model().attributeHasFieldErrors("memberDto", "nickname"))
                .andExpect(model().attributeHasFieldErrors("memberDto", "zipcode"))
                .andExpect(view().name("signUpForm"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("회원가입 처리: 회원가입 이메일, 닉네임 중복")
    void signUp_duplicate_id_and_nickname() throws Exception {
        MemberDto memberDto = createMemberDto("01012345678", "test@test.com", "asdf1234!", "테스트", "테스터", "12345", "테스트 주소", "테스트 상세주소", "true");
        memberService.join(memberDto);

        MultiValueMap<String, String> params = setParams(memberDto);

        mockMvc.perform(post(url)
                        .params(params)
                        .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(model().attributeHasFieldErrors("memberDto", "email"))
                .andExpect(model().attributeHasFieldErrors("memberDto", "nickname"))
                .andExpect(view().name("signUpForm"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("회원가입 처리: 회원가입 휴대폰 인증 x, 비밀번호 일치 x")
    void signUp_authCheck() throws Exception {
        MemberDto memberDto = createMemberDto("01012345678", "test@test.com", "asdf1234!", "테스트", "테스터", "12345", "테스트 주소", "테스트 상세주소", "false");

        MultiValueMap<String, String> params = setParams(memberDto);

        mockMvc.perform(post(url)
                        .params(params)
                        .accept(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(model().attributeHasFieldErrors("memberDto", "phoneCheck"))
                .andExpect(model().attributeHasFieldErrors("memberDto", "passwordCheck"))
                .andExpect(view().name("signUpForm"))
                .andExpect(status().isOk())
                .andDo(print());
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
}