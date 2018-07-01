package com.bashfan.mapper;

import com.bashfan.domain.Order;
import com.bashfan.domain.User;

import java.util.List;

public interface UserOrderMapper {
    User getUser(int id);

    List<Order> getUserOrders(int id);
}
