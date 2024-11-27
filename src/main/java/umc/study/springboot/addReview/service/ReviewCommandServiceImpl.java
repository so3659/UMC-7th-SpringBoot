package umc.study.springboot.addReview.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.springboot.addReview.converter.ReviewConverter;
import umc.study.springboot.addReview.dto.ReviewRequestDTO;
import umc.study.springboot.domain.Member;
import umc.study.springboot.domain.Review;
import umc.study.springboot.domain.Store;
import umc.study.springboot.repository.MemberRepository;
import umc.study.springboot.repository.StoreRepository.ReviewRepository;
import umc.study.springboot.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Review joinReview(ReviewRequestDTO.JoinReviewDTO request, Long id){
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Region not found"));

        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Store not found"));

        Review newReview = ReviewConverter.toReview(request);
        newReview.setMember(member);
        newReview.setStore(store);

        return reviewRepository.save(newReview);
    }

}
