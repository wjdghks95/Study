package com.example.springbook2.mvc;

import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

public class SessionAttributesTest extends AbstractDispatcherServletTest {
    @Test
    public void sessionAttr() throws ServletException, IOException {
        setClasses(UserController.class);

        // GET 요청 - form()
        initRequest("/user/edit").addParameter("id", "1");
        runService();

        HttpSession session = request.getSession();
        assertThat(session.getAttribute("user"), is(getModelAndView().getModel().get("user"))); // 모델로 리턴된 user와 HttpSession에 저장된 user가 동일한 오브젝트인지 확인한다.

        // POST 요청 - submit()
        initRequest("/user/edit", "POST").addParameter("id", "1").addParameter("name", "Spring2");
        request.setSession(session); // 앞 요청의 세션을 가져와 설정해서 세션 상태가 유지된 채로 다음 요청을 보내도록 만든다.
        runService();
        assertThat(((User) getModelAndView().getModel().get("user")).getEmail(), is("mail@spring.com")); // 두 번째 요청의 파라미터로는 저달되지 않았지만 세션에 저장되어 있던 user에는 있는 email이 반영되었는지 확인한다.
        assertThat(session.getAttribute("user"), is(nullValue())); // SessionStatus를 통해 세션에 저장된 user가 제거됐는지 확인한다.
    }

    @Controller
    @SessionAttributes("user")
    static class UserController {
        @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
        public User form(@RequestParam("id") int id) {
            return new User(id, "Spring", "mail@spring.com");
        }

        @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
        public void submit(@ModelAttribute User user, SessionStatus sessionStatus) {
            sessionStatus.setComplete();
        }
    }

    static class User {
        int id;
        String name;
        String email;

        public User(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public User() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
