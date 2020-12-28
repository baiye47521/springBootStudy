package com.hand.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author ludongpeng
 * @Date 2020/12/14 14:45
 * @Description:
 */
@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据库的所有信息
    //没有数据库的东西，怎么获取？
    @GetMapping("/userList")
    public List<Map<String, Object>> userList() {
        String sql = "select * from user";
        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }

    @GetMapping("/addUser")
    public String addUser() {
        String sql = "insert into user (id,name,pwd) values (11, '小楠', '4863113')";
        jdbcTemplate.update(sql);
        return "update-ok";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id) {
        String sql = "update user set name = ? ,pwd = ? where id = "+id;

        Object[] objects = new Object[2];

        objects[0] = "小明";
        objects[1] = "hhhhhh";

        jdbcTemplate.update(sql, objects);
        return "updateUser-ok";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        String sql = "delete from user where id = ?";
        jdbcTemplate.update(sql, id);
        return "deleteUser-ok";
    }
}
