package umc.spring.service.reviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.repository.ReviewRepository;
import umc.spring.service.memberService.MemberQueryServiceImpl;

@Service
@RequiredArgsConstructor
public class ReviewQueryServiceImpl implements ReviewQueryService{

    private final MemberQueryServiceImpl memberQueryService;

    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> getReviewList(Long memberId, Integer page) {

        Member member = memberQueryService.findMember(memberId).get();

        Page<Review> MyReview = reviewRepository.findAllByMember(member, PageRequest.of(page - 1, 10));
        return MyReview;
    }
}
