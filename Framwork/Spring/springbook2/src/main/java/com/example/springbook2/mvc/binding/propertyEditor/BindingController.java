package com.example.springbook2.mvc.binding.propertyEditor;

import com.example.springbook2.mvc.binding.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.inject.Provider;
import java.util.List;

@Controller
public class BindingController {

    @Inject
    Provider<CodePropertyEditor> codePropertyEditorProvider;

    // @InitBinder
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(Level.class, new LevelPropertyEditor());
        dataBinder.registerCustomEditor(int.class, "age", new MinMaxPropertyEditor(0, 200));
        dataBinder.registerCustomEditor(Code.class, new FakeCodePropertyEditor());
        dataBinder.registerCustomEditor(Code.class, codePropertyEditorProvider.get()); // Provider를 이용해 프로토타입 빈의 새 오브젝트를 가져온다.
    }

    // 특정 이름의 프로퍼티에만 적용되는 프로퍼티 에디터
    @RequestMapping("/add")
    public void add(@ModelAttribute Member member) {}

    // 프로토타입 빈 프로퍼티 에디터
    @Autowired
    private CodeService codeService;

    @ModelAttribute("userTypes")
    public List<Code> userTypes() {
        return this.codeService.findCodesByCodeCategory(CodeCategory.USERTYPE);
    }

    @RequestMapping("/add")
    public void add(@ModelAttribute User user) {
        user.setUserType(this.codeService.getCode(user.getUserTypeId())); // 참조 ID 값을 이용한 userType 설정
    }
}
