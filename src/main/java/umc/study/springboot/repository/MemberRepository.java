package umc.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}