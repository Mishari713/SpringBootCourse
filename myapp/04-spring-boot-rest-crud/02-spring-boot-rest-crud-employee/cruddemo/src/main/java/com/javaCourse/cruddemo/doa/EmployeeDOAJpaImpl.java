package com.javaCourse.cruddemo.doa;

import com.javaCourse.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDOAJpaImpl implements EmployeeDOA {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDOAJpaImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create a query
        TypedQuery<Employee> query = entityManager.createQuery("from Employee", Employee.class);

        // execute query and get a result list
        // return the results
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {

        // get employee
        // return employee
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {

        // save employee
        // return new employee
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {

        // find employee by id
        Employee employee = entityManager.find(Employee.class, id);

        // remove employee
        entityManager.remove(employee);
    }

    @Override
    public int deleteAll() {
        return entityManager.createQuery("DELETE FROM Employee").executeUpdate();
    }
}
