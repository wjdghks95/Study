package com.example.springbook2.mvc.messageConvertorAndAjax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AjaxController {

    @Autowired UserService userService;

    @RequestMapping(value = "checkloginid/{loginId}", method = RequestMethod.GET)
    @ResponseBody
    public Result checklogin(@PathVariable String loginId) {
        Result result = new Result();

        if (userService.isRegisteredLoginId(loginId)) {
            result.setDuplicated(true);
            result.setAvailableId(loginId + (int) (Math.random() * 1000));
        } else {
            result.setDuplicated(false);
        }
        return result;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public User registerpost(@RequestBody User user) {
        // user 검증과 등록 작업
        return user;
    }
}
