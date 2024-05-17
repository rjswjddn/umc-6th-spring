package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.service.memberMissionService.MemberMissionService;
import umc.spring.validation.annotation.CheckPage;
import umc.spring.web.dto.MemberMissionRequest;
import umc.spring.web.dto.MemberMissionResponse;


@RestController
@RequiredArgsConstructor
public class MemberMissionController {

    private final MemberMissionService memberMissionService;

    @PostMapping("/memberMission/add")
    public ApiResponse<MemberMissionResponse.MemberMissionAddResultDTO> memberMissionAdd(@RequestBody @Valid MemberMissionRequest.MemberMissionAddDTO memberMissionAddDTO){
        return ApiResponse.onSuccess(memberMissionService.addMemberMission(memberMissionAddDTO));
    }

    @GetMapping("/memberMission/{memberId}")
    @Operation(summary = "내가 진행중인 미션 조회 API",description = "내가 진행중인 미션 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "memberId", description = "회원 아이디, path variable 입니다!")
    })
    public ApiResponse<MemberMissionResponse.MemberMissionResponseListDTO> getMemberMissionList(@PathVariable(name="memberId") Long memberId, @CheckPage @RequestParam(name = "page") Integer page){
        return ApiResponse.onSuccess(MemberMissionConverter.toMemberMissionResponseListDTO(memberMissionService.getMemberMissionList(memberId, page)));
    }

    @PatchMapping("/memberMission")
    @Operation(summary = "미션 진행완료 API",description = "미션 진행완료 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    public ApiResponse<MemberMissionResponse.MemberMissionCompleteResultDTO> getMemberMissionList(@RequestBody MemberMissionRequest.MemberMissionCompleteDTO memberMissionCompleteDTO){
        return ApiResponse.onSuccess(memberMissionService.completeMemberMission(memberMissionCompleteDTO));
    }
}
