package umc.study.springboot.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.springboot.validation.validator.CategoriesExistValidator;
import umc.study.springboot.validation.validator.RegionExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RegionExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistRegion {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
