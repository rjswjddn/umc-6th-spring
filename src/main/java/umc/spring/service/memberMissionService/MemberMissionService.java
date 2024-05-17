package umc.spring.service.memberMissionService;

import org.springframework.data.domain.Page;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberMissionRequest;
import umc.spring.web.dto.MemberMissionResponse;

public interface MemberMissionService {
    MemberMissionResponse.MemberMissionAddResultDTO addMemberMission(MemberMissionRequest.MemberMissionAddDTO memberMissionAddDTO);

    Page<MemberMission> getMemberMissionList(Long memberId, Integer page);

    MemberMissionResponse.MemberMissionCompleteResultDTO completeMemberMission(MemberMissionRequest.MemberMissionCompleteDTO memberMissionCompleteDTO);
}
