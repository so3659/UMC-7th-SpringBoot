package umc.study.springboot.addMission.dto;

import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class JoinMissionDTO {
        String missionSpec;
        Integer reward;
        LocalDate deadline;
    }
}
