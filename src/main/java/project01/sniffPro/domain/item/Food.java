package project01.sniffPro.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "F")
@Getter @Setter
public class Food extends Item{

    private int volume; //용량
    private String ingredient; //성분표시

}
