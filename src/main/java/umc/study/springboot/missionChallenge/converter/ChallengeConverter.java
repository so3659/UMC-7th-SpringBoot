package umc.study.springboot.missionChallenge.converter;

import umc.study.springboot.addMission.dto.MissionRequestDTO;
import umc.study.springboot.domain.Mission;
import umc.study.springboot.domain.mapping.MemberMission;
import umc.study.springboot.missionChallenge.dto.ChallengeRequestDTO;
import umc.study.springboot.missionChallenge.dto.ChallengeResponseDTO;

import java.time.LocalDateTime;

public class ChallengeConverter {
    public static ChallengeResponseDTO.JoinChallengeResultDTO toJoinResultDTO(MemberMission challenge) {
        return ChallengeResponseDTO.JoinChallengeResultDTO.builder()
                .challengeId(challenge.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toChallenge(ChallengeRequestDTO.JoinChallengeDTO request) {
        return MemberMission.builder()
                .build();
    }
}
