package project01.sniffPro.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "W")
@Getter @Setter
public class Wear extends Item{

    private String size; //크기
    private String gbn; //모자, 옷, 신발

}
