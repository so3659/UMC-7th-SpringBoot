package umc.study.springboot.missionChallenge.dto;

import lombok.Getter;
import umc.study.springboot.validation.annotation.ExistMember;

import java.time.LocalDate;

public class ChallengeRequestDTO {

    @Getter
    public static class JoinChallengeDTO {
        @ExistMember
        Long memberId;
    }
}
