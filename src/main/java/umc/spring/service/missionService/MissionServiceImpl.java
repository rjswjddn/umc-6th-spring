package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionConverter;
import umc.spring.repository.MissionRepository;

import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;
    @Override
    public MissionResponse.MissionAddResultDTO addMission(MissionRequest.MissionAddDTO missionAddDTO) {
        return MissionConverter.toMissionAddResultDTO(missionRepository.save(MissionConverter.toMission(missionAddDTO)));
    }
}
