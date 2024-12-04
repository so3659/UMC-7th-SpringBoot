package umc.study.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.Region;
import umc.study.springboot.domain.Review;
import umc.study.springboot.domain.Store;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
