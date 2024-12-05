package umc.study.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.springboot.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);
}