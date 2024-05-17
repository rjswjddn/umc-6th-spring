package umc.spring.converter;

import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.RestaurantRequest;
import umc.spring.web.dto.RestaurantResponse;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

public class ReviewConverter {

    public static Review toReview(ReviewRequest.ReviewAddDTO reviewAddDTO) {

        return Review.builder()
                .content(reviewAddDTO.getContent())
                .rating(reviewAddDTO.getRating())
                .build();
    }

    public static ReviewResponse.ReviewAddResultDTO toReviewAddResultDTO(Review review) {
        return ReviewResponse.ReviewAddResultDTO.builder()
                .reviewId(review.getId())
                .build();
    }

}
