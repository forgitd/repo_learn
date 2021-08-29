package com.keqi.springcloud.service;

import com.keqi.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public List<Dept> queryAll() {
                return null;
            }

            @Override
            public Dept queryById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("客户端提供了服务降级，服务已经被关闭了")
                        .setDb_source("没有数据");
            }

            @Override
            public boolean addDept(Dept dept) {
                return false;
            }
        };
    }
}
