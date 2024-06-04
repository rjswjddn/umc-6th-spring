package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionResponse;

import java.util.List;
import java.util.stream.Collectors;

public class MemberMissionConverter {

    public static MemberMissionResponse.MemberMissionAddResultDTO toMemberMissionAddResultDTO (MemberMission memberMission) {
        return MemberMissionResponse.MemberMissionAddResultDTO.builder()
                .MemberMissionId(memberMission.getId())
                .build();
    }

    public static MemberMissionResponse.MemberMissionResponseDTO toMemberMissionResponseDTO(MemberMission memberMission){
        return MemberMissionResponse.MemberMissionResponseDTO.builder()
                .price(memberMission.getMission().getPrice())
                .restaurantName(memberMission.getMission().getRestaurant().getName())
                .endDate(memberMission.getMission().getEndDate())
                .point(memberMission.getMission().getPoint())
                .complete(memberMission.getComplete())
                .build();
    }
    public static MemberMissionResponse.MemberMissionResponseListDTO toMemberMissionResponseListDTO(Page<MemberMission> memberMissionList){

        List<MemberMissionResponse.MemberMissionResponseDTO> memberMissionResponseDTOList = memberMissionList.stream()
                .map(MemberMissionConverter::toMemberMissionResponseDTO)
                .collect(Collectors.toList());

        return MemberMissionResponse.MemberMissionResponseListDTO.builder()
                .memberMissionList(memberMissionResponseDTOList)
                .listSize(memberMissionResponseDTOList.size())
                .isFirst(memberMissionList.isFirst())
                .isLast(memberMissionList.isLast())
                .totalElements(memberMissionList.getTotalElements())
                .totalPage(memberMissionList.getTotalPages())
                .build();
    }
}
