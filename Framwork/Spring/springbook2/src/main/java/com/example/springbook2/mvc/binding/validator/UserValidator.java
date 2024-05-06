package com.example.springbook2.mvc.binding.validator;

import com.example.springbook2.mvc.binding.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return (User.class.isAssignableFrom(aClass));
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
//        if (user.getName() == null || user.getName().length() == 0) {
//            errors.rejectValue("name", "field.required", null, "입력해주세요.");
//        }
        ValidationUtils.rejectIfEmpty(errors, "name", "field.required");

        if (user.getAge() < 0) {
            errors.rejectValue("age", "field.min", new Object[]{0}, null);
        }
    }
}
