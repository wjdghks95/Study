package com.example.springbook2.mvc.controller;

import com.example.springbook2.mvc.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Controller
public class ParamController {

    // @PathVariable : 패스 변수
    @RequestMapping("/user/view/{id}")
    public String view(@PathVariable("id") int id) { return null;}

    // 다중 패스 변수
    @RequestMapping("/member/{memberCode}/order/{orderid}")
    public String lookup(@PathVariable("memberCode") String code, @PathVariable("orderid") int orderid) {
        return null;
    }

    // @RequestParam : 요청 파라미터
    public String view2(@RequestParam("id") int id) {return null;}
    public String view3(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("file")MultipartFile file) {return null;}
    public String add(@RequestParam Map<String, String> params) {return null;}
    public String view4(@RequestParam(value = "id", required = false, defaultValue = "-1") int id) {return null;}

    // @CookieValue : 쿠키 값
    public String check(@CookieValue("auth") String auth) {return null;}
    public String check2(@CookieValue(value = "auth", required = false, defaultValue = "NONE") String auth) {return null;}

    // @RequestHeader : 요청 헤더 정보
    public void header(@RequestHeader("Host") String host, @RequestHeader(value = "Keep-Alive", required = false, defaultValue = "1") long keepAlive) {}

    // Map, Model, ModelMap
    @RequestMapping("/hello")
    public void hello(ModelMap model) {
        User user = new User();
        model.addAttribute(user);
    }

    // @ModelAttribute
    @RequestMapping("/user/search")
    public String search(@ModelAttribute UserSearch userSearch) {return null;}

    // Errors, BindingResult
    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute UserSearch userSearch, BindingResult bindingResult) {return null;}

    // @RequestBody : XML이나 JSON 기반의 메시지를 사용하는 요청에 유용
    public void message(@RequestBody String body) {}

    // @Value
    @RequestMapping("/hello")
    public String hello(@Value("#{systemProperties['os.name']}") String osName) {return null;}
}
