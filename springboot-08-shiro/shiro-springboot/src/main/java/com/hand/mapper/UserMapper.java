package com.hand.mapper;

import com.hand.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author ludongpeng
 * @Date 2020/12/25 14:54
 * @Description:
 */
@Repository
@Mapper
public interface UserMapper {

    public User queryUserByName(String name);


}
