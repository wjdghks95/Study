package hello.springcore;

import hello.springcore.member.MemberRepository;
import hello.springcore.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

/**
 * ComponentScan - 현재 패키지 부터 하위에 있는 Component 를 모두 스캔
 */
@Configuration
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")/
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
