package dev.mk.First.web.validation;

import dev.mk.First.business.value.TrainingType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTrainingTypeWithNullImpl implements ConstraintValidator<ValidTrainingTypeWithNull, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null)
            return true;

        try {
            TrainingType.valueOf(value);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
