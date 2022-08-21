package project01.sniffPro.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import project01.sniffPro.domain.Address;
import project01.sniffPro.domain.Order;
import project01.sniffPro.domain.OrderStatus;
import project01.sniffPro.domain.User;
import project01.sniffPro.domain.item.Item;
import project01.sniffPro.domain.item.Supplies;
import project01.sniffPro.repository.OrderRepository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.test.util.AssertionErrors.assertEquals;


@SpringBootTest
@Transactional
public class OrderServiceTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @Test
    public void 상품_주문() throws Exception{
        //given
        User user = createUser();
        Item item = createSupplies("배변패드", 10000, 10);
        int orderStock = 2;

        //when
        Long orderId = orderService.order(user.getId(), item.getId(), orderStock);

        //then
        Order getOrder = orderRepository.findOne(orderId);
        assertEquals("상품 주문 시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());

     }

    private User createUser() {
        User user = new User();
        user.setName("kim");
        user.setAddress(new Address("서울", "한강", "123-123"));
        em.persist(user);
        return user;
    }

    private Supplies createSupplies(String name, int price, int stock) {

        Supplies supplies = new Supplies();
        supplies.setName(name);
        supplies.setPrice(price);
        supplies.setStock(stock);
        em.persist(supplies);

        return supplies;
    }

}