package wjdghks95.project.rol.config;

import org.apache.commons.compress.utils.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.security.crypto.password.PasswordEncoder;
import wjdghks95.project.rol.domain.entity.Category;
import wjdghks95.project.rol.domain.entity.CategoryName;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.repository.CategoryRepository;
import wjdghks95.project.rol.repository.MemberRepository;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Base64;

@Configuration
public class InitData {

    @Autowired MemberRepository memberRepository;
    @Autowired PasswordEncoder passwordEncoder;
    @Autowired CategoryRepository categoryRepository;

    @PostConstruct
    public void init() {

        Member member = Member.builder()
                .phone("010-1234-5678")
                .email("test@test.com")
                .password(passwordEncoder.encode("asdf1234!"))
                .name("test")
                .nickname("테스터")
                .zipcode("12345")
                .address("테스트주소")
                .detailAddress("테스트상세주소")
                .role("ROLE_USER")
                .profileImage(null)
                .build();

        memberRepository.save(member);

        CategoryName[] categoryNames = CategoryName.values();
        for (CategoryName categoryName : categoryNames) {
            Category category = Category.builder()
                    .categoryName(categoryName)
                    .build();

            categoryRepository.save(category);
        }
    }
}
