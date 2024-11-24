package umc.study.springboot.addStore.dto;

import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class JoinDTO{
        String name;
        String address;
    }
}
