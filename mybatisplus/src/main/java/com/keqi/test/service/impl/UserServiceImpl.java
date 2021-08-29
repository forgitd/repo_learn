package com.keqi.test.service.impl;

import com.keqi.test.entity.User;
import com.keqi.test.mapper.UserMapper;
import com.keqi.test.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author keqi
 * @since 2021-07-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
