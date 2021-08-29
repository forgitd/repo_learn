package com.keqi.springcloud.controller;

import com.keqi.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    // 消费者不应该有service层
    // RestFul    RestTemplate 直接调用

    // (url, 实体： Map , Class<T> responseType)
    @Autowired
    private RestTemplate restTemplate;  // 提供多种便捷访问远程http服务的方法，简单的restful服务模板。 get/post

//    private static final String REST_FUL_PREFIX = "http://localhost:8001";
    // 这里不应该是通过固定ip访问了，（应该是一个变量），而是通过服务名字访问
    private static final String REST_FUL_PREFIX = "http://SPRINGCLOUD-PROVIDER-DEPT";

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id) {
        // 第一个参数url，指向服务提供者
        // 第二个参数，为访问需要提供的参数
        // 第三个参数，为返回值 -- 参数即返回值
        return restTemplate.getForObject(REST_FUL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept) {
        return restTemplate.postForObject(REST_FUL_PREFIX + "/dept/add", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_FUL_PREFIX + "/dept/list",List.class);
    }

}
