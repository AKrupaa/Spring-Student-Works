package pl.arkadiusz.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.arkadiusz.domain.CarTypeDomain;

public class ManageCarTypeValidator implements Validator{

    @Override
    public boolean supports(Class<?> aClass) {
        return CarTypeDomain.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "description", "error.field.required");
    }

}
