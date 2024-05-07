package umc.spring.converter;

import umc.spring.domain.Restaurant;
import umc.spring.domain.RestaurantCategory;
import umc.spring.web.dto.RestaurantRequest;
import umc.spring.web.dto.RestaurantResponse;

public class RestaurantConverter {
    public static Restaurant toRestaurant(RestaurantRequest.RestaurantAddDTO restaurantAddDTO) {

        return Restaurant.builder()
                .name(restaurantAddDTO.getName())
                .ownerCode(restaurantAddDTO.getOwnerCode())
                .build();
    }

    public static RestaurantResponse.RestaurantAddResultDTO toRestaurantAddResultDTO(Restaurant restaurant) {
        return RestaurantResponse.RestaurantAddResultDTO.builder()
                .restaurantId(restaurant.getId())
                .ownerCode(restaurant.getOwnerCode())
                .build();
    }
}
