package umc.study.springboot.addStore.service;

import org.springframework.data.domain.Page;
import umc.study.springboot.addStore.dto.StoreRequestDTO;
import umc.study.springboot.domain.Review;
import umc.study.springboot.domain.Store;

public interface StoreCommandService {
    public Store joinStore(StoreRequestDTO.JoinDTO request);
    Page<Review> getReviewList(Long StoreId, Integer page);
}
