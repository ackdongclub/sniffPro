package project01.sniffPro.domain.Pet;

import lombok.Getter;
import lombok.Setter;
import project01.sniffPro.domain.Address;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "btype")
@Getter @Setter
public abstract class Pet {

    @Id @GeneratedValue
    @Column(name = "pet_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    private int age;
    private String Info;

    @Enumerated(EnumType.STRING)
    private Gender gender; //M, W
}
