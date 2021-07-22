package dev.mk.First.web.validation;

import dev.mk.First.business.value.CallType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCallTypeWithNullImpl
        implements ConstraintValidator<ValidCallTypeWithNull, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        try {
            CallType.valueOf(value);
            return true;
        }
        catch (Exception e ) {
            return false;
        }
    }
}
