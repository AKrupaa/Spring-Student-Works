package pl.arkadiusz.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.arkadiusz.domain.AppUser;


public class AppUserValidator implements Validator {

    EmailValidator emailValidator = EmailValidator.getInstance();


    public boolean supports(Class clazz) {
        return AppUser.class.isAssignableFrom(clazz);
    }


    public void validate(Object arg0, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "firstName", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "lastName", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "telephone", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "email", "error.field.required");

        if (errors.getErrorCount() == 0) {
            // nie mam pojecia czemu ((AppUser)arg0)
            if (StringUtils.hasText(((AppUser) arg0).getEmail()) && emailValidator.isValid(((AppUser) arg0).getEmail()) == false) {
                errors.rejectValue("email", "error.email.invalid");
            }
        }
    }
}
