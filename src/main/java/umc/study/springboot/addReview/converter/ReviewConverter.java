package umc.study.springboot.addReview.converter;

import umc.study.springboot.addReview.dto.ReviewRequestDTO;
import umc.study.springboot.addReview.dto.ReviewResponseDTO;
import umc.study.springboot.domain.Review;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static ReviewResponseDTO.JoinResultDTO toJoinResultDTO(Review review) {
        return ReviewResponseDTO.JoinResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.JoinReviewDTO request) {
        return Review.builder()
                .body(request.getBody())
                .score(request.getPoint())
                .build();
    }
}
