package umc.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMember_IdAndMission_Id(Long memberId, Long missionId);
}
