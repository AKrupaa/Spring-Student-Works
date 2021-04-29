package org.spring.plane.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.spring.plane.domain.CustomUserDomain;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomUserValidator implements Validator {

    EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean supports(Class clazz) {
        return CustomUserDomain.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object arg0, Errors errors) {

        ValidationUtils.rejectIfEmpty(errors, "firstName", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "login", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "password", "error.field.required");

        if (errors.getErrorCount() == 0) {
            if (StringUtils.hasText(((CustomUserDomain) arg0).getEmail()) && emailValidator.isValid(((CustomUserDomain) arg0).getEmail()) == false) {
                errors.rejectValue("email", "error.email.invalid");
            }
        }
    }

}

