package com.keqi.springcloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyIRuleConfig {

    @Bean
    public IRule myRule() {
        return new RoundRobinRule();
    }
}
