package project01.sniffPro.domain.Pet;

import lombok.Getter;
import lombok.Setter;
import project01.sniffPro.domain.item.Item;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "D")
@Getter @Setter
public class Dog extends Pet {

    private String kind; //견종
    private String dog; //강아지

}
