package umc.study.springboot.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
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
    private MissionStatus status;
}
