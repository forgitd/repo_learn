package com.keqi;

import com.keqi.service.TTLService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqSpringbootAdvanceApplicationTests {

    @Autowired
    private TTLService ttlService;

    @Test
    void contextLoads() {
    }

    @Test
    void TestTTl() {
        ttlService.ttl();
        ttlService.ttl_message();
    }

    @Test
    void TestTTl_d() {
        ttlService.ttl_d();
    }
}
