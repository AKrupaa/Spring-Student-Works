package pl.arkadiusz.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import pl.arkadiusz.domain.UserAddress;

import java.util.regex.Pattern;

public class AddressValidator implements Validator {


    public boolean supports(Class<?> aClass) {
        return UserAddress.class.isAssignableFrom(aClass);
    }


    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "address", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "zipCode", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "city", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "country", "error.field.required");
        ValidationUtils.rejectIfEmpty(errors, "state", "error.field.required");

//        if (errors.getErrorCount() == 0) {
////            .+ – dowolny symbol użyty co najmniej raz,
////            @ – małpka,
////            .+ – ponownie dowolny symbol użyty co najmniej raz,
////             \. – kropka rozumiana dosłownie (nie jako specjalny znak wyrażenia regularnego),
////             pl – następujące po sobie litery p i l.
////            \d{5} Match 5 digits
////            ^ Start of the string.
////            Pattern zipCodePattern = Pattern.compile("\d{2}-\d{3}");
//        }

    }


}
