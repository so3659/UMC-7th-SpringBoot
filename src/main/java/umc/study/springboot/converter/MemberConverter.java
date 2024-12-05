package umc.study.springboot.converter;

import org.springframework.data.domain.Page;
import umc.study.springboot.domain.Member;
import umc.study.springboot.domain.Mission;
import umc.study.springboot.domain.Review;
import umc.study.springboot.domain.enums.Gender;
import umc.study.springboot.domain.mapping.MemberMission;
import umc.study.springboot.web.dto.MemberRequestDTO;
import umc.study.springboot.web.dto.MemberResponseDTO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;
        switch (request.getGender()) {
            case 1: gender = Gender.MALE; break;
            case 2: gender = Gender.FEMALE; break;
            case 3: gender = Gender.NONE; break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .email(request.getEmail())
                .role(request.getRole()) // 추가된 코드
                .password(request.getPassword())
                .age(request.getAge())
                .memberPreferList(new ArrayList<>())
                .build();
    }

    public static MemberResponseDTO.ReviewPreviewDTO toReviewPreviewDTO(Review review){
        return MemberResponseDTO.ReviewPreviewDTO.builder()
                .name(review.getMember().getName())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .body(review.getBody())
                .build();
    }

    public static MemberResponseDTO.ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviewList){
        List<MemberResponseDTO.ReviewPreviewDTO> reviewPreviewDTOList = reviewList.stream()
                .map(MemberConverter::toReviewPreviewDTO).collect(Collectors.toList());

        return MemberResponseDTO.ReviewPreviewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreviewDTOList.size())
                .reviewList(reviewPreviewDTOList)
                .build();
    }

    public static MemberResponseDTO.MissionPreviewDTO toMissionPreviewDTO(MemberMission mission){
        return MemberResponseDTO.MissionPreviewDTO.builder()
                .ownerName(mission.getMember().getName())
                .storeName(mission.getMission().getStore().getName())
                .score(mission.getMission().getReward())
                .body(mission.getMission().getMissionSpec())
                .createdAt(mission.getMission().getCreatedAt().toLocalDate())
                .deadline(mission.getMission().getDeadline())
                .status(mission.getStatus())
                .build();
    }

    public static MemberResponseDTO.MissionPreviewListDTO toMissionPreviewListDTO(Page<MemberMission> missionList){
        List<MemberResponseDTO.MissionPreviewDTO> missionPreviewDTOList = missionList.stream()
                .map(MemberConverter::toMissionPreviewDTO).collect(Collectors.toList());

        return MemberResponseDTO.MissionPreviewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreviewDTOList.size())
                .missionList(missionPreviewDTOList)
                .build();
    }
}