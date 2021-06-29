package dev.mk.First.web.validation;

import dev.mk.First.business.value.TrainingType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidTrainingTypeValidator implements ConstraintValidator<ValidTrainingType, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        try {
            TrainingType.valueOf(value);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
