package umc.study.springboot.missionChallenge.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.springboot.domain.Member;
import umc.study.springboot.domain.Mission;
import umc.study.springboot.domain.mapping.MemberMission;
import umc.study.springboot.missionChallenge.converter.ChallengeConverter;
import umc.study.springboot.missionChallenge.dto.ChallengeRequestDTO;
import umc.study.springboot.repository.MemberMissionRepository;
import umc.study.springboot.repository.MemberRepository;
import umc.study.springboot.repository.MissionRepository;

@Service
@RequiredArgsConstructor
public class ChallengeCommandServiceImpl implements ChallengeCommandService {
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;

    private boolean isMemberAndMissionPresent(Long memberId, Long missionId) {
        return memberMissionRepository.existsByMember_IdAndMission_Id(memberId, missionId);
    }


    @Override
    @Transactional
    public MemberMission joinChallenge(ChallengeRequestDTO.JoinChallengeDTO request, Long id, Long missionID){
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        Mission challenge = missionRepository.findById(missionID)
                .orElseThrow(() -> new IllegalArgumentException("Mission not found"));

        if (isMemberAndMissionPresent(request.getMemberId(), missionID)) {
            throw new IllegalArgumentException("The member is already assigned to this mission.");
        }



        MemberMission newChallenge = ChallengeConverter.toChallenge(request);
        newChallenge.setMember(member);
        newChallenge.setChallenge(challenge);

        return memberMissionRepository.save(newChallenge);
    }
}
