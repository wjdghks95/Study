package com.example.ioccontaineranddi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

import javax.inject.Provider;
import java.util.Date;

public class SessionScopeLoginUser {

    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    static class LoginUser {
        String loginId;
        String name;
        Date loginTime;

        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(Date loginTime) {
            this.loginTime = loginTime;
        }
    }

    static class LoginService {
//        @Autowired
//        Provider<LoginUser> loginUserProvider; // DL 방식으로 접근할 수 있도록 JSR-330의 Provider로 DI 받는다.

        @Autowired LoginUser loginUser; // 프록시 DI 방식

        public void login(Login login) {
//            LoginUser loginUser = loginUserProvider.get(); // 같은 사용자의 세션 안에서는 매번 같은 오브젝트를 가져온다.
            loginUser.setLoginId(login.getLoginId());
            loginUser.setName(login.getName());
            loginUser.setLoginTime(new Date());

        }
    }

    static class Login {
        String loginId;
        String name;

        public String getLoginId() {
            return loginId;
        }

        public void setLoginId(String loginId) {
            this.loginId = loginId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
