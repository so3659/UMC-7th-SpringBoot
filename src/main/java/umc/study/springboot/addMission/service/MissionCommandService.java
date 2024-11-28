package umc.study.springboot.addMission.service;

import umc.study.springboot.addMission.dto.MissionRequestDTO;
import umc.study.springboot.domain.Mission;

public interface MissionCommandService {
    public Mission joinMission(MissionRequestDTO.JoinMissionDTO request, Long id);
}
