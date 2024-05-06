package com.example.springbook2.mvc.binding.validator;

import com.example.springbook2.mvc.binding.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class ValidController {

    @Autowired UserValidator validator;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(validator);
    }

    // 컨트롤러 코드에서 검증기를 사용하는 방법
    @RequestMapping("/add")
    public void add(@ModelAttribute User user, BindingResult result) {
        this.validator.validate(user, result);
        if (result.hasErrors()) {
            // 오류가 발견된 경우의 작업
        } else {
            // 오류가 없을 때의 작업
        }
    }

    // @Valid를 이용한 자동검증 수행
    @RequestMapping("/add2")
    public void add2(@ModelAttribute @Valid User user, BindingResult result) {
        this.validator.validate(user, result);
        if (result.hasErrors()) {
            // 오류가 발견된 경우의 작업
        } else {
            // 오류가 없을 때의 작업
        }
    }

}
