package umc.study.springboot.addStore.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

import java.util.List;

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

    @GetMapping("/{id}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "id", description = "가게의 아이디, path variable 입니다!")
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable @ExistStore Long id, @RequestParam(name = "page") Integer page) {
        Page<Review> reviewList=storeCommandService.getReviewList(id,page);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
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
