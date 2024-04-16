package com.itwill.jpa.relation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity(name = "COURSE_ENROLLMENT")
public class CourseEnrollment {
    @Id
    @SequenceGenerator(name = "COURSE_ENROLLMENT_ID_SEQ", sequenceName = "COURSE_ENROLLMENT_ID_SEQ", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_ENROLLMENT_ID_SEQ")
    private Long courseEnrollmentId;

    private Long courseId;

    private Long studentId;

}





