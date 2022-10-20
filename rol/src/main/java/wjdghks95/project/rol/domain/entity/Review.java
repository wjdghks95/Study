package wjdghks95.project.rol.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import wjdghks95.project.rol.domain.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Long id;

    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    private List<Image> images = new ArrayList<>();

    private String title;

    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

//    private String thumbnailImage;
//    private int rating;
//    private int countVisit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Review(String title, String content, Member member, Category category) {
        this.title = title;
        this.content = content;
        this.member = member;
        member.getReviewList().add(this);
        this.category = category;
        category.getReviewList().add(this);
    }

    /**
     * 연관관계 메서드
     */
    public void setImage(Image image) {
        this.images.add(image);
        image.setReview(this);
    }

//    private Like like;
//    private Comment comment;
//    private ReviewTag reviewTag;
}
