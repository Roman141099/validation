package org.validation.example.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Set;

public class CustomValidator implements ConstraintValidator<CustomValidationAnno, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(true){
            throw new NullPointerException();
        }
        return false;
    }
}
