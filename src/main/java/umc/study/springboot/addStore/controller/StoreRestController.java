package umc.study.springboot.addStore.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.springboot.addMission.converter.MissionConverter;
import umc.study.springboot.addMission.dto.MissionRequestDTO;
import umc.study.springboot.addMission.dto.MissionResponseDTO;
import umc.study.springboot.addMission.service.MissionCommandService;
import umc.study.springboot.addReview.converter.ReviewConverter;
import umc.study.springboot.addReview.dto.ReviewRequestDTO;
import umc.study.springboot.addReview.dto.ReviewResponseDTO;
import umc.study.springboot.addReview.service.ReviewCommandService;
import umc.study.springboot.addStore.converter.StoreConverter;
import umc.study.springboot.addStore.dto.StoreRequestDTO;
import umc.study.springboot.addStore.dto.StoreResponseDTO;
import umc.study.springboot.addStore.service.StoreCommandService;
import umc.study.springboot.apiPayload.ApiResponse;
import umc.study.springboot.domain.Mission;
import umc.study.springboot.domain.Review;
import umc.study.springboot.domain.Store;
import umc.study.springboot.domain.mapping.MemberMission;
import umc.study.springboot.missionChallenge.converter.ChallengeConverter;
import umc.study.springboot.missionChallenge.dto.ChallengeRequestDTO;
import umc.study.springboot.missionChallenge.dto.ChallengeResponseDTO;
import umc.study.springboot.missionChallenge.service.ChallengeCommandService;
import umc.study.springboot.validation.annotation.ExistMission;
import umc.study.springboot.validation.annotation.ExistStore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
@Validated
public class StoreRestController {

    private final StoreCommandService storeCommandService;
    private final ReviewCommandService reviewCommandService;
    private final MissionCommandService missionCommandService;
    private final ChallengeCommandService challengeCommandService;

    @Operation(summary = "Store 추가", description = "새로운 Store를 추가합니다.")
    @PostMapping("")
    public ApiResponse<StoreResponseDTO.JoinResultDTO> addStore(@RequestBody @Valid StoreRequestDTO.JoinDTO request) {
        Store store = storeCommandService.joinStore(request);
        return ApiResponse.onSuccess(StoreConverter.toJoinResultDTO(store));
    }

    @Operation(summary = "Review 추가", description = "특정 Store에 Review를 추가합니다.")
    @PostMapping("/{id}/reviews")
    public ApiResponse<ReviewResponseDTO.JoinReviewResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.JoinReviewDTO request, @PathVariable @ExistStore Long id) {
        Review review = reviewCommandService.joinReview(request, id);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }

    @Operation(summary = "Mission 추가", description = "특정 Store에 Mission를 추가합니다.")
    @PostMapping("/{id}/missions")
    public ApiResponse<MissionResponseDTO.JoinMissionResultDTO> addMission(@RequestBody @Valid MissionRequestDTO.JoinMissionDTO request, @PathVariable @ExistStore Long id) {
        Mission misson = missionCommandService.joinMission(request, id);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(misson));
    }

    @Operation(summary = "MissionChallenge 추가", description = "특정 User에 Mission를 추가합니다.")
    @PostMapping("/{id}/missions/{missionId}/challenge")
    public ApiResponse<ChallengeResponseDTO.JoinChallengeResultDTO> addChallenge(@RequestBody @Valid ChallengeRequestDTO.JoinChallengeDTO request, @PathVariable @ExistStore Long id, @PathVariable @ExistMission Long missionId) {
        MemberMission challenge = challengeCommandService.joinChallenge(request, id, missionId);
        return ApiResponse.onSuccess(ChallengeConverter.toJoinResultDTO(challenge));
    }
}
