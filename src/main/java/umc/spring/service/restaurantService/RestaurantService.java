package umc.spring.service.restaurantService;

import umc.spring.converter.RestaurantConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Restaurant;
import umc.spring.web.dto.RestaurantRequest;
import umc.spring.web.dto.RestaurantResponse;

import java.util.Optional;

public interface RestaurantService {

    Optional<Restaurant> findRestaurant(Long restaurantId);

    RestaurantResponse.RestaurantAddResultDTO addRestaurant(RestaurantRequest.RestaurantAddDTO restaurantAddDTO);
}
