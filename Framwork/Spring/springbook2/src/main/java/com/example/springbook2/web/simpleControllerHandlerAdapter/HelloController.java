package com.example.springbook2.web.simpleControllerHandlerAdapter;

import java.util.Map;

public class HelloController extends SimpleController{

    public HelloController() {
        this.setRequiredParams(new String[]{"name"});
        this.setViewName("/WEB-INF/views/hello.jsp");
    }

    @Override
    public void control(Map<String, String> params, Map<String, Object> model) throws Exception {
        model.put("message", "Hello " + params.get("name"));
    }
}
