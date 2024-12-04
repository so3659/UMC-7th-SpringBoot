package umc.study.springboot.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.springboot.apiPayload.ApiResponse;
import umc.study.springboot.converter.MemberConverter;
import umc.study.springboot.domain.Member;
import umc.study.springboot.domain.Review;
import umc.study.springboot.domain.mapping.MemberMission;
import umc.study.springboot.service.MemberService.MemberCommandService;
import umc.study.springboot.validation.annotation.ExistMember;
import umc.study.springboot.web.dto.MemberRequestDTO;
import umc.study.springboot.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }

    @GetMapping("/{id}/reviews")
    @Operation(summary = "유저가 작성한 리뷰 목록 조회 API", description = "특정 유저가 작성한 리뷰의 목록을 볼 수 있습니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "id", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.ReviewPreviewListDTO> getReviewList(@PathVariable @ExistMember Long id, @RequestParam(name = "page") Integer page){
        Page<Review> reviewList=memberCommandService.getReviewList(id,page);
        return ApiResponse.onSuccess(MemberConverter.toReviewPreviewListDTO(reviewList));
    }

    @GetMapping("/{id}/missions")
    @Operation(summary = "유저가 진행 중인 미션 목록 조회 API", description = "특정 유저가 진행 중인 미션의 목록을 볼 수 있습니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "id", description = "유저의 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberResponseDTO.MissionPreviewListDTO> getMissionList(@PathVariable @ExistMember Long id, @RequestParam(name = "page") Integer page){
        Page<MemberMission> missionList=memberCommandService.getMissionList(id,page);
        return ApiResponse.onSuccess(MemberConverter.toMissionPreviewListDTO(missionList));
    }
}