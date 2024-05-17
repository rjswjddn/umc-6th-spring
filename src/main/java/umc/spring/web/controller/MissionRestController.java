package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.missionService.MissionService;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;


@RestController
@RequiredArgsConstructor
public class MissionRestController {
    private final MissionService missionService;

    @PostMapping("/mission/add")
    public ApiResponse<MissionResponse.MissionAddResultDTO> missionAdd(@RequestBody @Valid MissionRequest.MissionAddDTO missionAddDTO){
        return ApiResponse.onSuccess(missionService.addMission(missionAddDTO));
    }
}
