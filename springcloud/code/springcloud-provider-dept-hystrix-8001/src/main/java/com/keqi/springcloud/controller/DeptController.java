package com.keqi.springcloud.controller;

import com.keqi.springcloud.pojo.Dept;
import com.keqi.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// 提供RestFul服务
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;


    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept addDept(@PathVariable("id") Long id) {
        // 1
        // id为空，就会返回null -- 没有这个id的情况
        // return deptService.queryById(id);

        // 2
        Dept dept = deptService.queryById(id);
        if (dept == null) {
            throw new RuntimeException("id>=" + id + "不存在，信息没有找到");
        }
        return dept;
    }

    // 3 熔断版
    public Dept hystrixGet(@PathVariable("id") Long id) {
        return new Dept().setDeptno(id).setDname("id>=" + id + "不存在，信息没有找到(hystrix)");
    }


}
