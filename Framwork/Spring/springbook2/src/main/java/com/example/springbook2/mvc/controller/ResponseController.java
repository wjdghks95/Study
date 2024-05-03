package com.example.springbook2.mvc.controller;

import com.example.springbook2.mvc.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ResponseController {

    // ModelAndView
    @RequestMapping("/hello")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response,
                                      @RequestParam String name, Model model) {
//        String name = request.getParameter("name");
//        return new ModelAndView("hello").addObject("name", name);

        model.addAttribute("name", name);
        return new ModelAndView("hello");
    }

    // String
    @RequestMapping("/hello")
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    // void -> RequestToViewNameResolver
    @RequestMapping("/hello2")
    public void hello2(@RequestParam String name, Model model) {
        model.addAttribute("name", name);
    }

    // Model Object
    @RequestMapping("/view")
    public User view(@RequestParam int id) {
//        return userService.getUser(id);
        return new User();
    }

    // View
    @Autowired
    MarshallingView marshallingView;

    @RequestMapping("/user/xml")
    public View userXml(@RequestParam int id) {
        return this.marshallingView;
    }

    // @ResponseBody
    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "<html><body>Hello Spring</body></html>";
    }
}