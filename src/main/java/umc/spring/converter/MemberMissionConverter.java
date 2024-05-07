package umc.spring.converter;

import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionResponse;

public class MemberMissionConverter {

    public static MemberMissionResponse.MemberMissionAddResultDTO toMemberMissionAddResultDTO (MemberMission memberMission) {
        return MemberMissionResponse.MemberMissionAddResultDTO.builder()
                .MemberMissionId(memberMission.getId())
                .build();
    }
}
