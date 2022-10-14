## Remember-Me 기능 구현  

### 이슈
- FormAuthenticationProvider 에서 token 저장시 principal 를 userDetails 로 저장하여 username 이 객체로 저장되어 PersistentRememberMeToken 의 username이 객체로 저장됨
### 해결
- Custom PersistentTokenBasedRememberMeServices 생성
  - AbstractRememberMeServices 를 구현한 UserLoginRememberMeService 생성
  - 저장소는 PersistentTokenRepository 구현체인 JdbcTokenRepositoryImpl 사용(이미 구현되어 있기 때문에 PersistentLogins 엔티티만 만들어서 사용가능)
  - 첫 로그인시 PersistentRememberMeToken 을 발행하여 저장하는데 이때 Authentication 의 principal 을 꺼내어 토큰의 username 으로 사용할 property 를 지정     
  - 자동 로그인시 RememberMeAuthenticationToken 리턴하는데 이때는 processAutoLoginCookie 에서 반환된 userDetails 에서 실제 엔티티를 꺼내어 principal 로 저장
  - 로그아웃시 Authentication 의 principal 를 꺼내어 username 으로 PersistentTokenRepository 에 존재하는 쿠키를 삭제

## 로그인, 로그아웃 기능 구현
### 이슈
1. get 방식의 Logout 사용시 LogoutFilter 가 동작하지 않음
2. csrf 사용시 권한 문제 발생
### 해결
1. logoutRequestMatcher 에 AntPathRequestMatcher 객체를 생성하여 url 을 매핑
2. 로그인 폼에 input type="hidden" th:name="_csrf" th:value="${_csrf.token}" 태그 추가