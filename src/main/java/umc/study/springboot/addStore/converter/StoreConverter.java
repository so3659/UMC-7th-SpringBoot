package umc.study.springboot.addStore.converter;

import umc.study.springboot.addStore.dto.StoreResponseDTO;
import umc.study.springboot.addStore.dto.StoreRequestDTO;
import umc.study.springboot.domain.Store;

import java.time.LocalDateTime;

public class StoreConverter {
    public static StoreResponseDTO.JoinResultDTO toJoinResultDTO(Store store) {
        return StoreResponseDTO.JoinResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.JoinDTO request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
