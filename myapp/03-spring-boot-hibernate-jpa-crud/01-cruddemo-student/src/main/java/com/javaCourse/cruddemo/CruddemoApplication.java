package com.javaCourse.cruddemo;

import com.javaCourse.cruddemo.dao.StudentDAO;
import com.javaCourse.cruddemo.dao.StudentDAOImpl;
import com.javaCourse.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);

			createMultipleStudents(studentDAO);

//			readsStudent(studentDAO);
			
//			queryForStudents(studentDAO);
			
//			queryForStudentsByLastName(studentDAO);

//			updateStudent(studentDAO);
			
//			deleteStudent(studentDAO);

//			deleteAllStudents(studentDAO);


		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteALl();
		System.out.println("Deleted rows count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int id = 3;
		System.out.println("Deleting student id: " + id);
		studentDAO.delete(id);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int id = 1;
		System.out.println("Getting student with id: " + id);
		Student student = studentDAO.findByID(id);

		// change first name to "Scooby"
		System.out.println("Updating student ...");
		student.setFirstName("John");

		// update the student
		studentDAO.update(student);

		// display the updated student
		System.out.println("Updated student: " + student);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> students = studentDAO.findByLastName("Doe");

		// display list of students
		for(Student student : students){
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student student : theStudents){
			System.out.println(student);
		}
	}

	private void readsStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student(
				"Paul", "Doe", "p.doe@email.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int id = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + id);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + id);
		Student student = studentDAO.findByID(id);

		// display student
		System.out.println("Found the student: " + student.toString());

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 = new Student(
				"John", "Doe", "j.doe@email.com");
		Student tempStudent2 = new Student(
				"Mary", "Poppins", "m.poppins@email.com");
		Student tempStudent3 = new Student(
				"Habib", "Adel", "h.adel@email.com");

		// save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student(
				"Paul", "Doe", "p.doe@email.com");

		// save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
