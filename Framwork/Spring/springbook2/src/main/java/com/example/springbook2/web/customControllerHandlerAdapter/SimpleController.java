package com.example.springbook2.web.customControllerHandlerAdapter;

import java.util.Map;

public interface SimpleController {
    void control(Map<String, String> params, Map<String, Object> model);
}
