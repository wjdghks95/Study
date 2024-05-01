package com.example.springbook2.web.customControllerHandlerAdapter;

import java.util.Map;

public class HelloController implements SimpleController{

    @ViewName("/WEB-INF/views/hello.jsp")
    @RequiredParams({"name"})
    @Override
    public void control(Map<String, String> params, Map<String, Object> model) {
        model.put("message", "Hello " + params.get("name"));
    }
}
