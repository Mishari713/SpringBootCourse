package com.javaCourse.cruddemo.service;

import com.javaCourse.cruddemo.doa.EmployeeDOA;
import com.javaCourse.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // create a doa object
    private EmployeeDOA employeeDOA;

    // injecting employeeDOA
    @Autowired
    public EmployeeServiceImpl(EmployeeDOA employeeDOA){
        this.employeeDOA = employeeDOA;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDOA.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDOA.findById(id);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDOA.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeDOA.deleteById(id);
    }

    @Transactional
    @Override
    public int deleteAll() {
        return employeeDOA.deleteAll();
    }
}
