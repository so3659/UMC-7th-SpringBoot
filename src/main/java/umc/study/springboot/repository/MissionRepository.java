package umc.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
