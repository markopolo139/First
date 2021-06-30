package dev.mk.First.web.validation;

import dev.mk.First.business.value.BloodType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidBloodTypeValidator implements ConstraintValidator<ValidBloodType, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try{
            BloodType.fromString(value);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
