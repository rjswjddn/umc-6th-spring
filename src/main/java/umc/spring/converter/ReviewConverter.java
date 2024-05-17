package umc.spring.converter;

import org.springframework.data.domain.Page;
import umc.spring.domain.Restaurant;
import umc.spring.domain.Review;
import umc.spring.web.dto.RestaurantRequest;
import umc.spring.web.dto.RestaurantResponse;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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


    public static ReviewResponse.ReviewResponseDTO toReviewResponseDTO(Review review){
        return ReviewResponse.ReviewResponseDTO.builder()
                .nickname(review.getMember().getName())
                .rating(review.getRating())
                .content(review.getContent())
                .createdAt(review.getCreatedAt())
                .build();
    }
    public static ReviewResponse.ReviewResponseListDTO toReviewResponseListDTO(Page<Review> reviewList){

        List<ReviewResponse.ReviewResponseDTO> reviewResponseDTOList = reviewList.stream()
                .map(ReviewConverter::toReviewResponseDTO)
                .collect(Collectors.toList());

        return ReviewResponse.ReviewResponseListDTO.builder()
                .reviewList(reviewResponseDTOList)
                .listSize(reviewResponseDTOList.size())
                .isFirst(reviewList.isFirst())
                .isLast(reviewList.isLast())
                .totalElements(reviewList.getTotalElements())
                .totalPage(reviewList.getTotalPages())
                .build();
    }
}
