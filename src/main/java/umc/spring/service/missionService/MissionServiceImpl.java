package umc.spring.service.missionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.repository.MissionRepository;

import umc.spring.service.restaurantService.RestaurantServiceImpl;
import umc.spring.service.reviewService.ReviewQueryServiceImpl;
import umc.spring.web.dto.MissionRequest;
import umc.spring.web.dto.MissionResponse;

@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService{

    private final MissionRepository missionRepository;

    private final RestaurantServiceImpl restaurantService;

    @Override
    public MissionResponse.MissionAddResultDTO addMission(MissionRequest.MissionAddDTO missionAddDTO) {
        return MissionConverter.toMissionAddResultDTO(missionRepository.save(MissionConverter.toMission(missionAddDTO)));
    }

    @Override
    public Page<Mission> getMissionList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantService.findRestaurant(restaurantId).get();

        Page<Mission> restaurantMission = missionRepository.findAllByRestaurant(restaurant, PageRequest.of(page - 1, 10));
        return restaurantMission;
    }
}
