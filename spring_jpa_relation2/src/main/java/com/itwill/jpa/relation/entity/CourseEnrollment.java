package com.itwill.jpa.relation.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity(name = "COURSE_ENROLLMENT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseEnrollment  {
	@Id 
	@SequenceGenerator(name = "COURSE_ENROLLMENT_ID_SEQ", sequenceName = "COURSE_ENROLLMENT_ID_SEQ", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "COURSE_ENROLLMENT_ID_SEQ")
    private Long courseEnrollmentId;
	
}





