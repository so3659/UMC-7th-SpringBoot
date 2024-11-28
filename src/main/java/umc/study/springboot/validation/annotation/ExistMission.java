package umc.study.springboot.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.study.springboot.validation.validator.MissionExistValidator;
import umc.study.springboot.validation.validator.RegionExistValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MissionExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistMission {
    String message() default "해당하는 미션이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
