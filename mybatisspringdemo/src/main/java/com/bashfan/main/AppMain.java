package com.bashfan.main;

import com.bashfan.config.AppConfig;
import com.bashfan.domain.Order;
import com.bashfan.mapper.UserOrderMapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AppMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        ctx.registerShutdownHook();

        UserOrderMapper userOrderMapper = ctx.getBean(UserOrderMapper.class);

        System.out.println(userOrderMapper.getUser(1));

        List<Order> ordres = userOrderMapper.getUserOrders(1);

        for (Order order : ordres) {
            System.out.println(order);
        }
    }
}
