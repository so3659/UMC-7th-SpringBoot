package umc.study.springboot.addStore.service;

import umc.study.springboot.addStore.dto.StoreRequestDTO;
import umc.study.springboot.domain.Store;

public interface StoreCommandService {
    public Store joinStore(StoreRequestDTO.JoinDTO request);
}
