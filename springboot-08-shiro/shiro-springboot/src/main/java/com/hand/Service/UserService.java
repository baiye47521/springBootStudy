package com.hand.Service;

import com.hand.pojo.User;

/**
 * @Author ludongpeng
 * @Date 2020/12/25 15:34
 * @Description:
 */
public interface UserService {
    public User queryUserByName(String name);
}
