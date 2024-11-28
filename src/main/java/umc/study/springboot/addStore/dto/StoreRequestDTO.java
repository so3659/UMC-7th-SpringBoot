package umc.study.springboot.addStore.dto;

import lombok.Getter;
import umc.study.springboot.validation.annotation.ExistRegion;

public class StoreRequestDTO {

    @Getter
    public static class JoinDTO{
        String name;
        String address;

        @ExistRegion
        Long regionNumber;
    }
}
