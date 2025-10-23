package com.javaCourse.cruddemo.service;

import com.javaCourse.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);

    void deleteAll();
}
