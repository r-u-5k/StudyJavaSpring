package com.itwill.transaction.spring;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmployeeMapper {
    @Insert("INSERT INTO employee (id, name, email, phone) VALUES (employee_id_seq.nextval, #{name}, #{email}, #{phone})")
    void insert(Employee employee);

    @Update("UPDATE employee SET name = #{name}, phone = #{phone},  email = #{email} WHERE id = #{id}")
    void update(Employee employee);

    @Delete("DELETE FROM employee  WHERE id = #{id}")
    void delete(int id);

    @Select("SELECT id, name, email, phone, salary FROM employee ORDER BY id DESC")
    List<Employee> list();

    @Select("SELECT id, name, email, phone, salary FROM employee WHERE id = #{id}")
    Employee detail(int id);

    @Update("UPDATE employee SET salary = (salary + #{amount}) WHERE id = #{id}")
    void increaseSalary(Map<String, Object> params);
}
