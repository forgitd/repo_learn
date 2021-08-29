package com.keqi;

import com.keqi.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqSpringbootApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    void contextLoads() {
        orderService.makeOrder("1", "1", 10);
    }

    @Test
    void test() {orderService.makeOrderDirect("2", "2",5);}

    @Test
    void tes1t() {orderService.makeOrderTopic("2", "2",5);}
}
