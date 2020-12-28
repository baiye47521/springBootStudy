package com.hand.dao;

import com.hand.pojo.Department;
import com.hand.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ludongpeng
 * @Date 2020/12/11 15:26
 * @Description:
 */
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();

        employees.put(101, new Employee(1001, "aa", "a32424@qq.com", 0, new Department(101, "教学部"), new Date()));
        employees.put(101, new Employee(1002, "bb", "b32424@qq.com", 1, new Department(102, "市场部"), new Date()));
        employees.put(101, new Employee(1003, "cc", "c32424@qq.com", 1, new Department(103, "教研部"), new Date()));
        employees.put(101, new Employee(1004, "dd", "d32424@qq.com", 0, new Department(104, "运营部"), new Date()));
    }

    //主键自增
    private static Integer initId = 1006;
    //增加员工
    public void save(Employee employee){
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    //查询员工
    public Collection<Employee> getAll(){
        return employees.values();
    }
    //通过id
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    //删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
