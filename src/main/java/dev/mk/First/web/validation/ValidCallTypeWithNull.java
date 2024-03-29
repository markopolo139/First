package dev.mk.First.web.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidCallTypeWithNullImpl.class)
public @interface ValidCallTypeWithNull {
    String message() default "Invalid Call type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
