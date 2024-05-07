package umc.spring.service.restaurantService;

import umc.spring.converter.RestaurantConverter;
import umc.spring.web.dto.RestaurantRequest;
import umc.spring.web.dto.RestaurantResponse;

public interface RestaurantService {
    RestaurantResponse.RestaurantAddResultDTO addRestaurant(RestaurantRequest.RestaurantAddDTO restaurantAddDTO);
}
