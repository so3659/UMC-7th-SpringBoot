package umc.study.springboot.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.study.springboot.domain.FoodCategory;
import umc.study.springboot.domain.Member;
import umc.study.springboot.domain.Mission;
import umc.study.springboot.domain.common.BaseEntity;
import umc.study.springboot.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15)")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;
}
