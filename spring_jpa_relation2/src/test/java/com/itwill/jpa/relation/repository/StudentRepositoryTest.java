package com.itwill.jpa.relation.repository;

import com.itwill.jpa.relation.entity.CourseEnrollment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.relation.entity.Student;

import jakarta.transaction.Transactional;

import java.util.List;

class StudentRepositoryTest extends SpringJpaApplicationTests {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    AddressRepository addressRepository;

//    @Disabled
    @Transactional
    @Rollback(false)
    @Test
    void saveStudentWithAddress() {


    }

//    @Disabled
    @Transactional
    @Rollback(false)
    @Test
    void selectStudentWithAddress() {
		Student student1 = studentRepository.findById(1L).get();
        System.out.println("student1 = " + student1);
        System.out.println("student1.getAddress() = " + student1.getAddress());
    }

//    @Disabled
    @Transactional
    @Rollback(false)
    @Test
    void selectStudentWithCourseEnrollments() {
		Student student1 = studentRepository.findById(1L).get();
        System.out.println("student1 = " + student1);
        List<CourseEnrollment> courseEnrollments = student1.getCourseEnrollments();
        for (CourseEnrollment courseEnrollment : courseEnrollments) {
            System.out.println(courseEnrollment.getCourse());
        }
    }

}











