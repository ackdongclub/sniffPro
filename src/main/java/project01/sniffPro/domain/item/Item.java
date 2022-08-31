package project01.sniffPro.domain.item;

import lombok.Getter;
import lombok.Setter;
import project01.sniffPro.domain.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public abstract class Item {

    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stock;

    @ManyToMany(mappedBy = "items")
    private List<Category> category = new ArrayList<>();

    //==비즈니스 로직==//
    //재고 수량 원래에서 취소하면 취소한 만큼 수량이 올라가야 한다
    public void addStock(int QTY) {
        this.stock += QTY;
    }

    //재고 수량을 주문한 만큼 빼줘야 한다
    public void removeStock(int QTY) {
        int reStock = this.stock - QTY;

        if(reStock < 0) {
            throw new IllegalStateException("수량이 부족합니다");
        }
        this.stock = reStock;
    }

    public void addPet(Pet pet) {

    }
}
