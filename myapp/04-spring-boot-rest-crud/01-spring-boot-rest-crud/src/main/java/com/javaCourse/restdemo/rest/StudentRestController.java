package com.javaCourse.restdemo.rest;

import com.javaCourse.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    //define @PostConstruct to load the student data ... only once!

    @PostConstruct
    public void loadData(){
        students = new ArrayList<>();
        students.add(new Student("John", "Paul"));
        students.add(new Student("Smith", "Carter"));
        students.add(new Student("Mac", "Lee"));
    }

    // define endpoint for "/students" - return a list of students

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    // define endpoint for "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        // just index into the list ...
        if( (studentId >= students.size() || studentId< 0)){
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return students.get(studentId);
    }
}
