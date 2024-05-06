package com.example.springbook2.mvc.binding.propertyEditor;

import com.example.springbook2.mvc.binding.Code;
import com.example.springbook2.mvc.binding.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
@Scope("prototype")
public class CodePropertyEditor extends PropertyEditorSupport {
    @Autowired
    CodeService codeService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        setValue(this.codeService.getCode(Integer.parseInt(text)));
    }

    @Override
    public String getAsText() {
        return String.valueOf(((Code) getValue()).getId());
    }
}
