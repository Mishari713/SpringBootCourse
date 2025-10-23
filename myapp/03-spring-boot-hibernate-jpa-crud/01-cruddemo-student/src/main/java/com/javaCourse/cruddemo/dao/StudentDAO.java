package com.javaCourse.cruddemo.dao;

import ch.qos.logback.core.model.INamedModel;
import com.javaCourse.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findByID(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);

    void delete(Integer id);

    int deleteALl();
}
