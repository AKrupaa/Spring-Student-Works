package pl.arkadiusz.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.arkadiusz.domain.CarDomain;

public class ManageCarsValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return CarDomain.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "description", "error.field.required");
    }
}
