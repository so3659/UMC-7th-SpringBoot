package umc.study.springboot.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
