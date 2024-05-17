package umc.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Member;
import umc.spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    Page<Review> findAllByMember(Member member, PageRequest pageRequest);
}
