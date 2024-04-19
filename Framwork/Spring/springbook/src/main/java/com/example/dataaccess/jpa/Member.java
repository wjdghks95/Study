package com.example.dataaccess.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // Member 클래스를 JPA가 관리하는 엔티티 오브젝트로 지정한다. 다른 설정이 없으면 매필되는 테이블 이름은 클래스 이름을 따른다.
public class Member {

    @Id // ID를 지정한다. DB의 기본키에 대응되는 필드다. 설정에 따라서 자동생성 키로 만들 수도 있다.
    int id;

    @Column(length = 100) // 필드 이름과 같은 "name"이라는 DB 컬럼에 매핑된다. 길이는 100자로 제한된다. 애노테이션을 이용하면 상세한 DB 매핑정보를 넣을 수 있다.
    String name;

    @Column(nullable = false)
    double point;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    public Member(int id, String name, double point) {
        this.id = id;
        this.name = name;
        this.point = point;
    }
}
