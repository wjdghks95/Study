package com.example.springbook2.mvc.binding.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MemberNoValidator implements ConstraintValidator<MemberNo, Object> {
    @Override
    public void initialize(MemberNo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return false;
    }
}
