package com.example.springbook2.mvc.requestMapping;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
public class GenericUserController extends GenericController<User, Integer, UserService>{

    @RequestMapping("/login")
    public String login(String userId, String password) {
        return null;
    }
}
