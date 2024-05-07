package umc.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.converter.ReviewConverter;
import umc.spring.repository.ReviewRepository;
import umc.spring.web.dto.ReviewRequest;
import umc.spring.web.dto.ReviewResponse;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository reviewRepository;
    @Override
    public ReviewResponse.ReviewAddResultDTO addReview(ReviewRequest.ReviewAddDTO reviewAddDTO) {

        return ReviewConverter.toReviewAddResultDTO(reviewRepository.save(ReviewConverter.toReview(reviewAddDTO)));
    }
}
