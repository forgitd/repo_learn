package com.keqi.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.keqi.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//@Repository
// 继承BaseMapper接口， 就可以使用基本CRUD操作
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
