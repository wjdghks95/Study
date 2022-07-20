package hello.jpa.hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Team {

    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;

    private String name;

    /**
     * 양방향 매핑 (주인x)
     *  - 주인이 아닌쪽은 읽기만 가능
     *  - mappedBy 속성으로 주인 지정
     */
    @OneToMany(mappedBy = "team")
    List<Member> members = new ArrayList<Member>();
}
