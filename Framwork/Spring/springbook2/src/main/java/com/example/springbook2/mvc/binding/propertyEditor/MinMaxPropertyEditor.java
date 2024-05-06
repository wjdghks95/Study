package com.example.springbook2.mvc.binding.propertyEditor;

import java.beans.PropertyEditorSupport;

public class MinMaxPropertyEditor extends PropertyEditorSupport {
    int min;
    int max;

    public MinMaxPropertyEditor(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String getAsText() {
        return String.valueOf((Integer) this.getValue());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        int val = Integer.parseInt(text);

        // 최대값, 최소값과 비교해서 범위를 넘었으면 강제로 값을 수정해준다.
        if (val < min) val = min;
        else if (val > max) val = max;
        setValue(val);
    }
}
