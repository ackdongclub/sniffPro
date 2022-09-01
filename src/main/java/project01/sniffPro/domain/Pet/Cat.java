package project01.sniffPro.domain.Pet;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "C")
@Getter @Setter
public class Cat extends Pet {

    private String kind; //묘종
    private String cat; //고양이

}
