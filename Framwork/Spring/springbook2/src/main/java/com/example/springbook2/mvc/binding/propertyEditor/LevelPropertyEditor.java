package com.example.springbook2.mvc.binding.propertyEditor;

import com.example.springbook2.mvc.binding.Level;

import java.beans.PropertyEditorSupport;

public class LevelPropertyEditor extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        return String.valueOf(((Level) this.getValue()).intValue()); // setValue에 의해 저정된 Level 타입 오브젝트를 가져와서 값을 문자로 변환한다.
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        this.setValue(Level.valueOf(Integer.parseInt(text.trim()))); // 파라미터로 제공된 문자열을 Level의 스태틱 메소드를 이용해 문자열로 변환한 뒤에 저장한다.
    }
}
