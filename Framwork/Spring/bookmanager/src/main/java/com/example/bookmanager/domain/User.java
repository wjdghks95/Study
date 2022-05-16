package com.example.bookmanager.domain;

import com.example.bookmanager.domain.listener.Auditable;
import com.example.bookmanager.domain.listener.UserEntityListener;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

//@Getter
//@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
//@EqualsAndHashCode
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Builder
@Entity
@EntityListeners(value = { UserEntityListener.class })
//@Table(name = "user", indexes = {@Index(columnList = "name")}, uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
public class User extends BaseEntity implements Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @NonNull
    private String email;

    @Enumerated(value = EnumType.STRING)
    private Gender gender;

//    @Column(updatable = false)
//    @CreatedDate
//    private LocalDateTime createdAt;
//
//    @Column(insertable = false)
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

    @Transient
    private String testData;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;


//
//    @PreRemove
//    public void preRemove() {
//        System.out.println(">>> preRemove");
//    }
//
//    @PostPersist
//    public void postPersist() {
//        System.out.println(">>> postPersist");
//    }
//
//    @PostUpdate
//    public void postUpdate() {
//        System.out.println(">>> postUpdate");
//    }
//
//    @PostRemove
//    public void postRemove() {
//        System.out.println(">>> postRemove");
//    }
//
//    @PostLoad
//    public void postLoad() {
//        System.out.println(">>> postLoad");
//    }
}
