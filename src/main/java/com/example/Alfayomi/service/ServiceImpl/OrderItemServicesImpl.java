package com.example.Alfayomi.service.ServiceImpl;

import com.example.Alfayomi.repo.OrderItemRepo;
import com.example.Alfayomi.repo.OrderRepo;
import com.example.Alfayomi.repo.ProductRepo;
import com.example.Alfayomi.service.OrderItemServices;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServicesImpl implements OrderItemServices {

    private final OrderItemRepo orderItemRepo;
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public OrderItemServicesImpl(OrderItemRepo orderItemRepo, ProductRepo productRepo, OrderRepo orderRepo) {
        this.orderItemRepo = orderItemRepo;
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    @Override
    public void addItemToOrder(Long orderId, Long productId, int quantity) {



    }
}
