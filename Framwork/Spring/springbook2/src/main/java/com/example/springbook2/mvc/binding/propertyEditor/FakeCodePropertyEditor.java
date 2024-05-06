package com.example.springbook2.mvc.binding.propertyEditor;

import com.example.springbook2.mvc.binding.Code;
import com.example.springbook2.mvc.binding.FakeCode;

import java.beans.PropertyEditorSupport;

// 모조 오브젝트 프로퍼티 에디터
public class FakeCodePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // Code 오브젝트를 만들고 폼의 셀렉트박스에서 전달된 id 값만 넣어준다.
        // 모조 오브젝트
//        Code code = new Code();
        // 안전한 모조 오브젝트
        Code code = new FakeCode();
        code.setId(Integer.parseInt(text));
        setValue(code);
    }

    @Override
    public String getAsText() {
        return String.valueOf(((Code)getValue()).getId());
    }
}
