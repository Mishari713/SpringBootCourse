package com.javaCourse.cruddemo.doa;

import com.javaCourse.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDOA {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

    int deleteAll();

}
