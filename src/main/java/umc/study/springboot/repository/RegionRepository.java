package umc.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
