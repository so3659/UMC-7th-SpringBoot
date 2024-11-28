package umc.study.springboot.missionChallenge.service;

import umc.study.springboot.domain.mapping.MemberMission;
import umc.study.springboot.missionChallenge.dto.ChallengeRequestDTO;

public interface ChallengeCommandService {
    public MemberMission joinChallenge(ChallengeRequestDTO.JoinChallengeDTO request, Long id, Long missionID);
}
