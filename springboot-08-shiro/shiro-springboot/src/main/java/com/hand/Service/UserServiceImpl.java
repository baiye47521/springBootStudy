package com.hand.Service;

import com.hand.mapper.UserMapper;
import com.hand.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author ludongpeng
 * @Date 2020/12/25 15:35
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
