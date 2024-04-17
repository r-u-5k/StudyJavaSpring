package com.itwill.jpa.relation.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.relation.entity.Address;
import com.itwill.jpa.relation.entity.Course;
import com.itwill.jpa.relation.entity.CourseEnrollment;
import com.itwill.jpa.relation.entity.Student;
import com.itwill.jpa.relation.entity.Tutor;

class CourseEnrollmentRepositoryTest extends SpringJpaApplicationTests {

    @Autowired
    CourseEnrollmentRepository courseEnrollmentRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

//    @Disabled
    @Test
    @Transactional
    @Rollback(false)
    void saveCourseEnrollmentWithStudentAndCourse1() {
        Student student8 = studentRepository.findById(8L).get();
        Course course6 = courseRepository.findById(6L).get();
        CourseEnrollment courseEnrollment = CourseEnrollment.builder().student(student8).course(course6).build();
//        CourseEnrollment courseEnrollment2 = CourseEnrollment.builder().student(student8).course(course6).build();
        courseEnrollmentRepository.save(courseEnrollment);
//        courseEnrollmentRepository.save(courseEnrollment2); // ORA-00001: 무결성 제약 조건(JDEVELOPER43.COURSE_ENROLLMENT_UQ)에 위배됩니다
    }

//    @Disabled
    @Test
    @Transactional
    @Rollback(false)
    void saveCourseEnrollmentWithStudentAndCourse2() {

    }

    @Disabled
    @Test
    @Transactional
    @Rollback(false)
    void selectCourseEnrollmentWithStudentAndCourse() {
        CourseEnrollment courseEnrollment = courseEnrollmentRepository.findById(1L).get();
        System.out.println("courseEnrollment = " + courseEnrollment);
        System.out.println("courseEnrollment.getCourse() = " + courseEnrollment.getCourse());
        System.out.println("courseEnrollment.getStudent() = " + courseEnrollment.getStudent());

    }
}










