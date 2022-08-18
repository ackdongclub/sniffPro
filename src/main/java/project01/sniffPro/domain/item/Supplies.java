package project01.sniffPro.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("S")
@Getter
@Setter
public class Supplies extends Item{

    @Enumerated(EnumType.STRING)
    private sCategory stype; //FOOD, HOUSE, DRESS, CLEANING

    private String sInfo;

}
