package project01.sniffPro.domain;

import lombok.Getter;
import lombok.Setter;
import project01.sniffPro.domain.item.Item;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@Table(name = "order_item")
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item; //상품

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order; //주문

    private int orderPrice; //금액
    private int count; //수량

    public void cancel() {
    }
}
