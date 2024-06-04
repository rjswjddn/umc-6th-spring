package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.validation.annotation.ExistMemberMission;

public class MemberMissionRequest {

    @Getter
    public static class MemberMissionAddDTO {

        @ExistMemberMission
        Long missionId;

    }

    @Getter
    public static class MemberMissionCompleteDTO {

        @ExistMemberMission
        Long MemberMissionId;
    }
}
