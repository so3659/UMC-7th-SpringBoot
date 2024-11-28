package umc.study.springboot.missionChallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class ChallengeResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinChallengeResultDTO {
        Long challengeId;
        LocalDateTime createdAt;
    }
}
