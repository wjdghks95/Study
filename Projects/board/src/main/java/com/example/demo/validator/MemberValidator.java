package com.example.demo.validator;

import com.example.demo.domain.dto.MemberDto;
import com.example.demo.domain.entity.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class MemberValidator implements Validator {

    @Autowired MemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return MemberDto.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        MemberDto memberDto = (MemberDto) target;
        Optional<Member> findMember = memberRepository.findByUsername(memberDto.getUsername());
        if (!findMember.isEmpty()) {
            errors.reject(null, "중복된 회원 이름입니다.");
        }
    }
}
