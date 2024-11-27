package umc.study.springboot.addStore.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.springboot.addStore.converter.StoreConverter;
import umc.study.springboot.addStore.dto.StoreRequestDTO;
import umc.study.springboot.apiPayload.code.status.ErrorStatus;
import umc.study.springboot.apiPayload.exception.handler.ErrorHandler;
import umc.study.springboot.domain.Region;
import umc.study.springboot.domain.Store;
import umc.study.springboot.repository.RegionRepository;
import umc.study.springboot.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinDTO request) {

        Region region = regionRepository.findById(request.getRegionNumber())
                .orElseThrow(() -> new IllegalArgumentException("Region not found"));

        Store newStore = StoreConverter.toStore(request);
        newStore.setRegion(region); // Region 설정

        // 3. Store 저장
        return storeRepository.save(newStore);
    }
}
