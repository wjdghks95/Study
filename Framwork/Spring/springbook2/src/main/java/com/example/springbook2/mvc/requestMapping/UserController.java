package com.example.springbook2.mvc.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/add") public String add() { return null;}
    @RequestMapping("/edit") public String edit() { return null;}
    @RequestMapping("/delete") public String delete() { return null;}
    @RequestMapping(method = RequestMethod.GET) public String form() {return null;}
    @RequestMapping(method = RequestMethod.POST) public String submit() {return null;}
    @RequestMapping("/hello") public String hello() { return null;}
    @RequestMapping("/main") public String main() { return null;}
}
