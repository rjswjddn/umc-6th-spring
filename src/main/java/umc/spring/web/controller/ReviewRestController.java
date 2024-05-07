package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.reviewService.ReviewService;
import umc.spring.web.dto.RestaurantResponse;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

@RestController
@RequiredArgsConstructor
public class ReviewRestController {
    private final ReviewService reviewService;

    @PostMapping("/reviews")
    public ApiResponse<ReviewResponse.ReviewAddResultDTO> reviewAdd(@RequestBody @Valid ReviewRequest.ReviewAddDTO reviewAddDTO){
        return ApiResponse.onSuccess(reviewService.addReview(reviewAddDTO));
    }
}
