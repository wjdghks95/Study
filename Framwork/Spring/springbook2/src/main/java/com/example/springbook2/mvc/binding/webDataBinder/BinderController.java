package com.example.springbook2.mvc.binding.webDataBinder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class BinderController {

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setAllowedFields("name", "email", "tel");
        dataBinder.setRequiredFields("name");
        dataBinder.setFieldMarkerPrefix("_");
        dataBinder.setFieldDefaultPrefix("!");
    }
}
