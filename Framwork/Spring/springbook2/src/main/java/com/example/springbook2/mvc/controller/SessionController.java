package com.example.springbook2.mvc.controller;

import com.example.springbook2.mvc.User;
import com.example.springbook2.mvc.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Map;

@Controller
@SessionAttributes("user")
public class SessionController {

    @Autowired
    UserService userService;

    // 수정 폼 출력
    // @SessionAttributes : 모델정보에 담긴 오브젝트에 SessionAttributes 라고 지정한 모델이 있으면 자동으로 세션에 저장
    @RequestMapping(value = "/user/edit", method = RequestMethod.GET)
    public String form(@RequestParam int id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "user/edit";
    }

    // 폼 서브밋 처리
    // @SessionAttributes : @ModelAttribute 오브젝트를 세션에서 가져옴
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String submit(@ModelAttribute User user, SessionStatus sessionStatus) {
        this.userService.updateUser(user);
        sessionStatus.setComplete(); // 현재 컨트롤러에 의해 세션에 저장된 정보를 모두 제거해준다.
        return "user/editsucess";
    }

    // DB 재조회
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String submit(@ModelAttribute User formUser, @RequestParam int id) {
        User user = this.userService.getUser(id); // DB에서 모든 필드 정보가 다 담긴 User 오브젝트를 다시 가져온다.

        // 폼에서 전달된 정보를 받은 formUser의 내용을 DB에서 가져온 user 오브젝트에 넣어준다.
        user.setName(formUser.getName());
        user.setPassword(formUser.getPassword());
        user.setEmail(formUser.getEmail());

        this.userService.updateUser(user);
        return "user/editsucess";
    }

    // 파라미터 맵
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public String submit(@RequestParam Map<String, String> userMap) {
        this.userService.updateUserByUserMap(userMap);
        return "user/editsucess";
    }

    // 신규 등록 폼
    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public String addForm(Model model) {
        User user = new User(); // 등록 폼에서 사용할 User 오브젝트 생성과 초기화
        model.addAttribute("user", user); // 생성된 user 오브젝트를 모델로 등록해서 폼을 출력할 때 참고하고, @SessionAttribute에 의해 저장되도록 만든다.
        return "user/edit";
    }

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public String addSubmit(@ModelAttribute User user) {
        return "user/editsucess";
    }
}
