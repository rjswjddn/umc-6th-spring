package umc.spring.service.reviewService;

import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

public interface ReviewService {
    ReviewResponse.ReviewAddResultDTO addReview(ReviewRequest.ReviewAddDTO reviewAddDTO);
}
