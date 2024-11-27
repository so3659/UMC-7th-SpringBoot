package umc.study.springboot.addReview.dto;

import lombok.Getter;
import umc.study.springboot.validation.annotation.ExistMember;

public class ReviewRequestDTO {

    @Getter
    public static class JoinReviewDTO {
        String body;
        Float point;

        @ExistMember
        Long memberId;
    }
}
