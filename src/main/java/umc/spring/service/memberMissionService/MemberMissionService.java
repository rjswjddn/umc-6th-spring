package umc.spring.service.memberMissionService;

import umc.spring.web.dto.MemberMissionRequest;
import umc.spring.web.dto.MemberMissionResponse;

public interface MemberMissionService {
    MemberMissionResponse.MemberMissionAddResultDTO addMemberMission(MemberMissionRequest.MemberMissionAddDTO memberMissionAddDTO);
}
