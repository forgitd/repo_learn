package com.keqi.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
//   @AllArgsConstructor   有有参构造了
@Accessors(chain = true)   // 支持链式写法
public class Dept implements Serializable {
    // 实体类，     orm   类表关系映射，对象关系映射

    private Long deptno;
    private String dname;

    // 显示当前数据库名字的字段
    // 微服务，一个服务对应一个数据库，同一信息可能存在不同数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
