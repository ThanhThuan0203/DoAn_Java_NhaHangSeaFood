package hutech.nguyenthanhthuan.Library.service;

import hutech.nguyenthanhthuan.Library.model.Order;
import hutech.nguyenthanhthuan.Library.model.ShoppingCart;

import java.util.List;

public interface OrderService {
    Order save(ShoppingCart shoppingCart);

    List<Order> findAll(String username);

    List<Order> findALlOrders();

    Order acceptOrder(Long id);

    void cancelOrder(Long id);
}
