package umc.spring.service.reviewService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

import java.util.Optional;

public interface ReviewQueryService {
    Page<Review> getReviewList(Long memberId, Integer page);
}
