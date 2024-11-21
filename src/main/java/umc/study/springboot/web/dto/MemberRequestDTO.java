package umc.study.springboot.web.dto;

import lombok.Getter;
import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        String name;
        Integer gender;
        Integer birthYear;
        Integer birthMonth;
        Integer birthDay;
        Integer age;
        String address;
        String specAddress;
        List<Long> preferCategory;
    }
}