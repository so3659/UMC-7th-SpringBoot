package umc.study.springboot.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1456016381L;

    public static final QMember member = new QMember("member1");

    public final umc.study.springboot.domain.common.QBaseEntity _super = new umc.study.springboot.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.study.springboot.domain.enums.Gender> gender = createEnum("gender", umc.study.springboot.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<umc.study.springboot.domain.mapping.MemberAgree, umc.study.springboot.domain.mapping.QMemberAgree> memberAgreeList = this.<umc.study.springboot.domain.mapping.MemberAgree, umc.study.springboot.domain.mapping.QMemberAgree>createList("memberAgreeList", umc.study.springboot.domain.mapping.MemberAgree.class, umc.study.springboot.domain.mapping.QMemberAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.study.springboot.domain.mapping.MemberMission, umc.study.springboot.domain.mapping.QMemberMission> memberMissionList = this.<umc.study.springboot.domain.mapping.MemberMission, umc.study.springboot.domain.mapping.QMemberMission>createList("memberMissionList", umc.study.springboot.domain.mapping.MemberMission.class, umc.study.springboot.domain.mapping.QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<umc.study.springboot.domain.mapping.MemberPrefer, umc.study.springboot.domain.mapping.QMemberPrefer> memberPreferList = this.<umc.study.springboot.domain.mapping.MemberPrefer, umc.study.springboot.domain.mapping.QMemberPrefer>createList("memberPreferList", umc.study.springboot.domain.mapping.MemberPrefer.class, umc.study.springboot.domain.mapping.QMemberPrefer.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.study.springboot.domain.enums.Role> role = createEnum("role", umc.study.springboot.domain.enums.Role.class);

    public final EnumPath<umc.study.springboot.domain.enums.SocialType> socialType = createEnum("socialType", umc.study.springboot.domain.enums.SocialType.class);

    public final StringPath specAddress = createString("specAddress");

    public final EnumPath<umc.study.springboot.domain.enums.MemberStatus> status = createEnum("status", umc.study.springboot.domain.enums.MemberStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

