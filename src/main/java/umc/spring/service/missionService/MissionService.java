package umc.spring.service.missionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

public interface MissionService {
    MissionResponse.MissionAddResultDTO addMission(MissionRequest.MissionAddDTO missionAddDTO);

    Page<Mission> getMissionList(Long restaurantId, Integer page);
}
