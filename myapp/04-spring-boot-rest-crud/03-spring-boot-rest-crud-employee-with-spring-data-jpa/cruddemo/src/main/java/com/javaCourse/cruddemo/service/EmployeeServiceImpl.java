package com.javaCourse.cruddemo.service;

import com.javaCourse.cruddemo.doa.EmployeeRepository;
import com.javaCourse.cruddemo.entity.Employee;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // create a doa object
    private EmployeeRepository employeeRepository;

    // injecting employeeDOA
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {

        Optional<Employee> result = employeeRepository.findById(id);

        Employee employee = null;
        if (result.isPresent()){
            employee = result.get();
        }
        else{
            // we didn't find the employee
            throw new EntityNotFoundException("Did not find employee id - " + id);
        }
        return employee;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
