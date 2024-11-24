package umc.study.springboot.addStore.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.springboot.addStore.converter.StoreConverter;
import umc.study.springboot.addStore.dto.StoreRequestDTO;
import umc.study.springboot.apiPayload.code.status.ErrorStatus;
import umc.study.springboot.apiPayload.exception.handler.FoodCategoryHandler;
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

        Store newStore = StoreConverter.toStore(request);
        String storeAddress = request.getAddress();

        // if문을 사용하여 값이 없으면 예외를 던짐
        Region region = regionRepository.findByName(storeAddress)
                .orElse(null); // Optional에서 값이 없으면 null 반환

        if (region == null) {
            throw new FoodCategoryHandler(ErrorStatus.STORE_ADDRESS_NOT_FOUND);
        }

        return storeRepository.save(newStore);
    }
}
