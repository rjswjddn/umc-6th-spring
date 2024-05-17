package umc.spring.service.missionService;

import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

public interface MissionService {
    MissionResponse.MissionAddResultDTO addMission(MissionRequest.MissionAddDTO missionAddDTO);
}
