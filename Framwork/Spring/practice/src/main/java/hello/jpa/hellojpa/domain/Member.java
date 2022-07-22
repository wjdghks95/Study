package hello.jpa.hellojpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter
public class Member {

    private String id;
    private String userName;

    public Member() {
    }

    public Member(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
