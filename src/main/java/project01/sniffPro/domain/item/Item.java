package project01.sniffPro.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stackQuantity;

    //비즈니스 로직
    public void addStock(int quantity) {
        this.stackQuantity += quantity;
    }

    public void removeStock(int quantity) {
        int reStock = this.stackQuantity - quantity;
        if(reStock < 0) {
            throw new IllegalStateException("수량이 부족합니다");
        }
        this.stackQuantity = reStock;
    }
}
