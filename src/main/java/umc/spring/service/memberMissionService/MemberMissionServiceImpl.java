package umc.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.web.dto.MemberMissionRequest;
import umc.spring.web.dto.MemberMissionResponse;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;

    @Override
    public MemberMissionResponse.MemberMissionAddResultDTO addMemberMission(MemberMissionRequest.MemberMissionAddDTO memberMissionAddDTO) {

        return MemberMissionConverter.toMemberMissionAddResultDTO(memberMissionRepository.save(MemberMission.builder()
                        .mission(missionRepository.findById(memberMissionAddDTO.getMissionId()).get())
                        .build()));
    }
}
