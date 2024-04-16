package com.itwill.jpa.relation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "stud_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "course_id")
    private Course course;

}





