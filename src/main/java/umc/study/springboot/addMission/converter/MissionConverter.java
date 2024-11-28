package umc.study.springboot.addMission.converter;


import umc.study.springboot.addMission.dto.MissionRequestDTO;
import umc.study.springboot.addMission.dto.MissionResponseDTO;
import umc.study.springboot.addReview.dto.ReviewRequestDTO;
import umc.study.springboot.domain.Mission;
import umc.study.springboot.domain.Review;

import java.time.LocalDateTime;

public class MissionConverter {
    public static MissionResponseDTO.JoinMissionResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinMissionResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.JoinMissionDTO request) {
        return Mission.builder()
                .deadline(request.getDeadline())
                .missionSpec(request.getMissionSpec())
                .reward(request.getReward())
                .build();
    }
}
