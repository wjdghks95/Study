package com.example.springbook2.mvc.binding.converterAndFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class BindingController {

    @Autowired
    ConversionService conversionService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.setConversionService(this.conversionService);
    }
}
