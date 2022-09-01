package project01.sniffPro.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "P")
@Getter @Setter
public class Play extends Item{

    private int size; //크기
    private String howTo; //놀이 방법

}
