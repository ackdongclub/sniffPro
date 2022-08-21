package project01.sniffPro.service;

import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project01.sniffPro.domain.*;
import project01.sniffPro.domain.item.Item;
import project01.sniffPro.repository.ItemRepository;
import project01.sniffPro.repository.OrderRepository;
import project01.sniffPro.repository.UserRepository;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    private final ItemRepository itemRepository;

    //주문
    @Transactional
    public Long order(Long userId, Long itemId, int count) {

        //엔티티 조회
        User user = userRepository.findOne(userId);
        Item item = itemRepository.findOne(itemId);

        //배달 생성
        Delivery delivery = new Delivery();
        delivery.setAddress(user.getAddress());
        delivery.setStatus(DeliveryStatus.READY);

        //주문 상품 생성
        OrderItem orderItem = OrderItem.createOrder(item, item.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(user, delivery, orderItem);

        //주문 저장
        orderRepository.save(order);
        return order.getId();
    }

    @Transactional
    //주문 취소
    public void cancelOrder(Long orderId) {

        //주문 조회
        Order order = orderRepository.findOne(orderId);
        //주문 취소 실행
        order.cancel();

    }
}
