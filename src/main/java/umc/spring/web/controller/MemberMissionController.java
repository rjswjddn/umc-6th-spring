package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.memberMissionService.MemberMissionService;
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
}
