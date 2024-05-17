package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;
import umc.spring.web.dto.ReviewResponse;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponse.MissionResponseDTO toMissionResponseDTO(Mission mission){
        return MissionResponse.MissionResponseDTO.builder()
                .price(mission.getPrice())
                .restaurantName(mission.getRestaurant().getName())
                .endDate(mission.getEndDate())
                .point(mission.getPoint())
                .build();
    }
    public static MissionResponse.MissionResponseListDTO toMissionResponseListDTO(Page<Mission> missionList){

        List<MissionResponse.MissionResponseDTO> missionResponseDTOList = missionList.stream()
                .map(MissionConverter::toMissionResponseDTO)
                .collect(Collectors.toList());

        return MissionResponse.MissionResponseListDTO.builder()
                .missionList(missionResponseDTOList)
                .listSize(missionResponseDTOList.size())
                .isFirst(missionList.isFirst())
                .isLast(missionList.isLast())
                .totalElements(missionList.getTotalElements())
                .totalPage(missionList.getTotalPages())
                .build();
    }
}
