package umc.study.springboot.service.MemberService;

import umc.study.springboot.domain.Member;
import umc.study.springboot.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);
}
