package umc.study.springboot.addStore.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.springboot.addStore.converter.StoreConverter;
import umc.study.springboot.addStore.dto.StoreRequestDTO;
import umc.study.springboot.apiPayload.code.status.ErrorStatus;
import umc.study.springboot.apiPayload.exception.handler.ErrorHandler;
import umc.study.springboot.domain.Region;
import umc.study.springboot.domain.Review;
import umc.study.springboot.domain.Store;
import umc.study.springboot.repository.RegionRepository;
import umc.study.springboot.repository.StoreRepository.ReviewRepository;
import umc.study.springboot.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Store joinStore(StoreRequestDTO.JoinDTO request) {

        Region region = regionRepository.findById(request.getRegionNumber())
                .orElseThrow(() -> new IllegalArgumentException("Region not found"));

        Store newStore = StoreConverter.toStore(request);
        newStore.setRegion(region);

        return storeRepository.save(newStore);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }
}
