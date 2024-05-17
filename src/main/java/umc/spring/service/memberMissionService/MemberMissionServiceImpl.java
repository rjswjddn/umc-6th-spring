package umc.spring.service.memberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.converter.MemberMissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MemberMissionRepository;
import umc.spring.repository.MissionRepository;
import umc.spring.service.memberService.MemberQueryServiceImpl;
import umc.spring.web.dto.MemberMissionRequest;
import umc.spring.web.dto.MemberMissionResponse;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{

    private final MemberMissionRepository memberMissionRepository;
    private final MissionRepository missionRepository;
    private final MemberQueryServiceImpl memberQueryService;

    @Override
    public MemberMissionResponse.MemberMissionAddResultDTO addMemberMission(MemberMissionRequest.MemberMissionAddDTO memberMissionAddDTO) {

        return MemberMissionConverter.toMemberMissionAddResultDTO(memberMissionRepository.save(MemberMission.builder()
                        .mission(missionRepository.findById(memberMissionAddDTO.getMissionId()).get())
                        .build()));
    }

    @Override
    public Page<MemberMission> getMemberMissionList(Long memberId, Integer page) {
        Member member = memberQueryService.findMember(memberId).get();

        Page<MemberMission> memberMission = memberMissionRepository.findAllByMember(member, PageRequest.of(page - 1, 10));
        return memberMission;
    }

    @Override
    public MemberMissionResponse.MemberMissionCompleteResultDTO completeMemberMission(MemberMissionRequest.MemberMissionCompleteDTO memberMissionCompleteDTO) {

        MemberMission memberMission = memberMissionRepository.findById(memberMissionCompleteDTO.getMemberMissionId()).get();
        memberMission.completeMemberMission();
        memberMissionRepository.save(memberMission);
        return MemberMissionResponse.MemberMissionCompleteResultDTO.builder()
                .MemberMissionId(memberMission.getId())
                .build();
    }
}

