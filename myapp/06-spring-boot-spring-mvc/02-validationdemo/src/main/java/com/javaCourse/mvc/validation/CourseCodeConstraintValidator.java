package com.javaCourse.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String courseCodeInput, ConstraintValidatorContext constraintValidatorContext) {
        if(courseCodeInput != null){
            return courseCodeInput.startsWith(coursePrefix);
        } else {
            return true;
        }
    }
}
