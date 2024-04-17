package com.itwill.jpa.relation.repository;

import com.itwill.SpringJpaApplicationTests;
import com.itwill.jpa.relation.entity.Course;
import com.itwill.jpa.relation.entity.CourseEnrollment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CourseRepositoryTest extends SpringJpaApplicationTests {
    @Autowired
    CourseRepository courseRepository;

    @Test
    @Transactional
    @Rollback(false)
    void selectCourseWithCourseEnrollments() {
        Course course1 = courseRepository.findById(1L).get();
        List<CourseEnrollment> courseEnrollments = course1.getCourseEnrollments();
        for (CourseEnrollment courseEnrollment : courseEnrollments) {
            System.out.println(courseEnrollment.getStudent());
        }
    }

}