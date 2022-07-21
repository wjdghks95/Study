package hello.jpa.hellojpa.cascade;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

// 자식 엔티티
@Entity
@Getter @Setter
public class Child {

    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Parent parent;
}
