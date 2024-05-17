package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.TempConverter;
import umc.spring.service.restaurantService.RestaurantService;
import umc.spring.service.restaurantService.RestaurantServiceImpl;
import umc.spring.web.dto.RestaurantRequest;
import umc.spring.web.dto.RestaurantResponse;
import umc.spring.web.dto.TempResponse;

@RestController
@RequiredArgsConstructor
public class RestaurantRestController {
    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/add")
    public ApiResponse<RestaurantResponse.RestaurantAddResultDTO> restaurantAdd(@RequestBody @Valid RestaurantRequest.RestaurantAddDTO restaurantAddDTO){
        return ApiResponse.onSuccess(restaurantService.addRestaurant(restaurantAddDTO));
    }
}
