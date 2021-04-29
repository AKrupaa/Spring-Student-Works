package org.spring.plane.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.spring.plane.domain.Airplane;
import org.spring.plane.domain.CustomUserDomain;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class AirplaneValidator implements Validator {

//    EmailValidator emailValidator = EmailValidator.getInstance();

    @Override
    public boolean supports(Class clazz) {
        return Airplane.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object arg0, Errors errors) {
//        ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "departure", "error.field.departure");
        ValidationUtils.rejectIfEmpty(errors, "arrival", "error.field.arrival");

//        if (errors.getErrorCount() == 0) {
//            if (StringUtils.hasText(String.valueOf(((Airplane) arg0).getArrival())) && StringUtils.hasText(String.valueOf(((Airplane) arg0).getDeparture())))  {
////                errors.rejectValue("email", "error.email.invalid");
//                errors.rejectValue("departure", "error.field.departure");
//                errors.rejectValue("arrival", "error.field.arrival");
//            }
//        }
    }

}

