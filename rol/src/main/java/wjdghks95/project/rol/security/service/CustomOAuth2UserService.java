package wjdghks95.project.rol.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import wjdghks95.project.rol.domain.entity.Member;
import wjdghks95.project.rol.repository.MemberRepository;
import wjdghks95.project.rol.security.oauth.GoogleUserInfo;
import wjdghks95.project.rol.security.oauth.OAuth2UserInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService(); // DefaultOAuth2UserService 를 통해 User 정보를 가져와야 하기 때문에 대리자 생성
        OAuth2User oAuth2User = delegate.loadUser(userRequest); // User 정보를 가지고옴
        System.out.println(oAuth2User.getAttributes());

        OAuth2UserInfo oAuth2UserInfo = null; // OAuth 로그인시 회원정보를 가져오는 인터페이스

        if (userRequest.getClientRegistration().getRegistrationId().equals("google")) { // 구글 로그인 요청
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }

        String name = oAuth2UserInfo.getName();
        String password = passwordEncoder.encode("OAuth2LoginPassword");
        String email = oAuth2UserInfo.getEmail();
        String picture = oAuth2UserInfo.getPicture();

        Member member = memberRepository.findByEmail(email).orElse(null);

        if (member == null) {
            member = Member.builder()
                    .email(email)
                    .password(password)
                    .name(name)
                    .nickname("유저" + UUID.randomUUID().toString().substring(0, 5))
                    .profileImage(picture)
                    .role("USER")
                    .build();
            memberRepository.save(member);
        }

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(member.getRole()));

        return new MemberContext(member, roles, oAuth2User.getAttributes());
    }
}
