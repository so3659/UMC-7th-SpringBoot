package umc.study.springboot.web.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import umc.study.springboot.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto {
        @NotBlank(message = "이름은 공백일 수 없습니다.") // 공백 허용 안 함
        String name;

        @NotNull(message = "성별은 필수 입력 항목입니다.") // null 허용 안 함
        @Min(value = 0, message = "성별 값은 0 이상이어야 합니다.")
        @Max(value = 1, message = "성별 값은 1 이하이어야 합니다.") // 0 또는 1만 허용 (예: 남/여)
        Integer gender;

        @NotNull(message = "출생 연도는 필수 입력 항목입니다.")
        @Min(value = 1900, message = "출생 연도는 1900년 이후여야 합니다.") // 연도 범위 제한
        @Max(value = 2100, message = "출생 연도는 2100년 이전이어야 합니다.") // 상한선 제한
        Integer birthYear;

        @NotNull(message = "출생 월은 필수 입력 항목입니다.")
        @Min(value = 1, message = "출생 월은 1월 이상이어야 합니다.") // 월 범위 제한
        @Max(value = 12, message = "출생 월은 12월 이하이어야 합니다.") // 1~12만 허용
        Integer birthMonth;

        @NotNull(message = "출생 일은 필수 입력 항목입니다.")
        @Min(value = 1, message = "출생 일은 1일 이상이어야 합니다.") // 일 범위 제한
        @Max(value = 31, message = "출생 일은 31일 이하이어야 합니다.") // 1~31만 허용
        Integer birthDay;

        @NotNull(message = "나이는 필수 입력 항목입니다.")
        Integer age;

        @NotBlank(message = "주소는 공백일 수 없습니다.")
        @Size(min = 5, max = 12, message = "주소는 5자 이상, 12자 이하로 입력해주세요.") // 길이 제한
        String address;

        @NotBlank(message = "상세 주소는 공백일 수 없습니다.")
        @Size(min = 5, max = 12, message = "상세 주소는 5자 이상, 12자 이하로 입력해주세요.") // 길이 제한
        String specAddress;

        @NotNull(message = "선호 카테고리는 필수 입력 항목입니다.")
        @ExistCategories // 커스텀 어노테이션으로 존재하는 카테고리만 허용
        @Size(min = 1, message = "최소 한 개 이상의 선호 카테고리를 선택해야 합니다.") // 최소 하나 이상 필요
        List<Long> preferCategory;
    }
}