package umc.spring.service.restaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Restaurant;
import umc.spring.repository.RestaurantRepository;
import umc.spring.web.dto.RestaurantRequest;
import umc.spring.web.dto.RestaurantResponse;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    @Override
    public RestaurantResponse.RestaurantAddResultDTO addRestaurant(RestaurantRequest.RestaurantAddDTO restaurantAddDTO) {
        Restaurant restaurant = restaurantRepository.save(RestaurantConverter.toRestaurant(restaurantAddDTO));
        return RestaurantConverter.toRestaurantAddResultDTO(restaurant);
    }
}
