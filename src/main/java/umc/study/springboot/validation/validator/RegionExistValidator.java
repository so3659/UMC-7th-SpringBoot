package umc.study.springboot.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.study.springboot.apiPayload.code.status.ErrorStatus;
import umc.study.springboot.repository.FoodCategoryRepository;
import umc.study.springboot.repository.RegionRepository;
import umc.study.springboot.validation.annotation.ExistCategories;
import umc.study.springboot.validation.annotation.ExistRegion;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegionExistValidator implements ConstraintValidator<ExistRegion, Long> {

    private final RegionRepository regionRepository;

    @Override
    public void initialize(ExistRegion constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {

        boolean isValid = regionRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.STORE_ADDRESS_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;

    }

}
