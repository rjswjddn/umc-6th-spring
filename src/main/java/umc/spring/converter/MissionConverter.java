package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

public class MissionConverter {
    public static Mission toMission(MissionRequest.MissionAddDTO missionAddDTO) {

        return Mission.builder()
                .point(missionAddDTO.getPoint())
                .price(missionAddDTO.getPrice())
                .build();
    }

    public static MissionResponse.MissionAddResultDTO toMissionAddResultDTO(Mission mission) {
        return MissionResponse.MissionAddResultDTO.builder()
                .missionId(mission.getId())
                .build();
    }
}