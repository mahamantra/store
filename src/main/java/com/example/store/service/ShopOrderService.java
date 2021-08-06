package com.example.store.service;

import com.example.store.model.OrderItem;
import com.example.store.model.ShopOrder;
import com.example.store.model.Toy;
import com.example.store.repository.ShopOrderRepository;
import com.example.store.repository.ToyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShopOrderService {

    private final ShopOrderRepository shopOrderRepository;
    private final ToyRepository toyRepository;

    public List<ShopOrder> findAll() {
        return shopOrderRepository.findAll();
    }


    @Transactional
    public void save(ShopOrder shopOrder) {
        shopOrder.getOrderItems().forEach(orderItem -> orderItem.setOrder(shopOrder));
        ShopOrder savedOrder = shopOrderRepository.save(shopOrder);
        List<OrderItem> orderItems = savedOrder.getOrderItems();

        for (OrderItem orderItem : orderItems) {
            Toy toy = orderItem.getToy();
            Optional<Toy> optionalToy = toyRepository.findById(toy.getId());
            Toy editableToy = optionalToy.get();
            editableToy.setCount(editableToy.getCount() - orderItem.getCount());
            toyRepository.save(editableToy);
        }
    }

}
