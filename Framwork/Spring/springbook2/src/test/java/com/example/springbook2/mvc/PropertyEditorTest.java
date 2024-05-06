package com.example.springbook2.mvc;

import com.example.springbook2.mvc.binding.Level;
import com.example.springbook2.mvc.binding.propertyEditor.LevelPropertyEditor;
import org.junit.Test;
import org.springframework.beans.propertyeditors.CharsetEditor;
import org.springframework.web.bind.WebDataBinder;

import java.nio.charset.Charset;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropertyEditorTest {
    @Test
    public void charsetEditor() {
        CharsetEditor charsetEditor = new CharsetEditor();
        charsetEditor.setAsText("UTF-8");
        assertThat(charsetEditor.getValue(), is(instanceOf(Charset.class)));
        assertThat((Charset) charsetEditor.getValue(), is(Charset.forName("UTF-8")));
    }

    @Test
    public void levelEditor() {
        LevelPropertyEditor levelEditor = new LevelPropertyEditor();
        levelEditor.setAsText("3");
        assertThat((Level) levelEditor.getValue(), is(Level.GOLD));

        levelEditor.setValue(Level.BASIC);
        assertThat(levelEditor.getAsText(), is("1"));
    }

    @Test
    public void webDataBinder() {
        WebDataBinder dataBinder = new WebDataBinder(null);
        dataBinder.registerCustomEditor(Level.class, new LevelPropertyEditor());
        assertThat(dataBinder.convertIfNecessary("1", Level.class), is(Level.BASIC));
    }
}
