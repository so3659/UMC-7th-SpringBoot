package umc.study.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.Member;
import umc.study.springboot.domain.Mission;
import umc.study.springboot.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMember_IdAndMission_Id(Long memberId, Long missionId);
    Page<MemberMission> findAllByMember(Member member, PageRequest pageRequest);
    MemberMission findByMission(Mission mission);
}
