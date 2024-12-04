package umc.study.springboot.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.study.springboot.apiPayload.code.status.ErrorStatus;
import umc.study.springboot.apiPayload.exception.handler.ErrorHandler;
import umc.study.springboot.converter.MemberConverter;
import umc.study.springboot.converter.MemberPreferConverter;
import umc.study.springboot.domain.FoodCategory;
import umc.study.springboot.domain.Member;
import umc.study.springboot.domain.Mission;
import umc.study.springboot.domain.Review;
import umc.study.springboot.domain.mapping.MemberMission;
import umc.study.springboot.domain.mapping.MemberPrefer;
import umc.study.springboot.repository.FoodCategoryRepository;
import umc.study.springboot.repository.MemberMissionRepository;
import umc.study.springboot.repository.MemberRepository;
import umc.study.springboot.repository.MissionRepository;
import umc.study.springboot.repository.StoreRepository.ReviewRepository;
import umc.study.springboot.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final ReviewRepository reviewRepository;
    private final MemberMissionRepository memberMissionRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new ErrorHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }

    @Override
    public Page<Review> getReviewList(Long id, Integer page){
        Member member = memberRepository.findById(id).get();

        Page<Review> memberPage=reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
        return memberPage;
    }

    @Override
    public Page<MemberMission> getMissionList(Long id, Integer page){
        Member member = memberRepository.findById(id).get();

        Page<MemberMission> missionPage=memberMissionRepository.findAllByMember(member, PageRequest.of(page, 10));
        return missionPage;
    }

    @Override
    public MemberMission setMissionStatus(Long id, String status){
        Mission mission = missionRepository.findById(id).get();

        MemberMission changedMission=memberMissionRepository.findByMission(mission);
        changedMission.setStatus(status);
        return memberMissionRepository.save(changedMission);
    }
}
