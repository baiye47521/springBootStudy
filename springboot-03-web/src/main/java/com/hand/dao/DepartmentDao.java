package com.hand.dao;

import com.hand.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ludongpeng
 * @Date 2020/12/11 15:19
 * @Description:
 */
@Repository
public class DepartmentDao {

    //模拟数据库
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "教学部"));
        departments.put(102, new Department(102, "市场部"));
        departments.put(103, new Department(103, "教研部"));
        departments.put(104, new Department(104, "运营部"));
    }

    //获得部门所有信息
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }

}
