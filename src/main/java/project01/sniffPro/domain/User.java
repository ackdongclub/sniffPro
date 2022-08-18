package project01.sniffPro.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    private int userPass;
    private String name;
    private int userTel;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user")
    private List<Order> order = new ArrayList<>();

}
