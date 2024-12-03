package umc.study.springboot.service.MemberService;

import org.springframework.data.domain.Page;
import umc.study.springboot.domain.Member;
import umc.study.springboot.domain.Review;
import umc.study.springboot.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);

    public Page<Review> getReviewList(Long id, Integer page);
}
