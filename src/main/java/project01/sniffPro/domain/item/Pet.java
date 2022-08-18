package project01.sniffPro.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("P")
@Getter
@Setter
public class Pet extends Item{

    private int Age;

    @Enumerated(EnumType.STRING)
    private Gender gender; // M, F
}
