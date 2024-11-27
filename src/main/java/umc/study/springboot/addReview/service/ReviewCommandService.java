package umc.study.springboot.addReview.service;

import umc.study.springboot.addReview.dto.ReviewRequestDTO;
import umc.study.springboot.domain.Review;

public interface ReviewCommandService {
    public Review joinReview(ReviewRequestDTO.JoinReviewDTO request, Long id);
}
