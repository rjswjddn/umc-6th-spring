package umc.spring.service.restaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RestaurantRepository;
import umc.spring.web.dto.RestaurantRequest;
import umc.spring.web.dto.RestaurantResponse;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponse.RestaurantAddResultDTO addRestaurant(RestaurantRequest.RestaurantAddDTO restaurantAddDTO) {
        return RestaurantConverter.toRestaurantAddResultDTO(restaurantRepository.save(RestaurantConverter.toRestaurant(restaurantAddDTO)));
    }

    @Override
    public Optional<Restaurant> findRestaurant(Long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }
}
