package com.hand.dao;

import com.hand.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author ludongpeng
 * @Date 2020/12/14 18:25
 * @Description:
 */
@Mapper  //mybatis下的mapper类
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);



}
