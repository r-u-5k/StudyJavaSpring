package com.itwill.jpa.entity;

import java.util.Date;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@EqualsAndHashCode

@DynamicUpdate
@DynamicInsert
@Entity
public class Guest {
	@Id
	@SequenceGenerator(name = "guest_guest_no_seq", sequenceName = "guest_guest_no_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_guest_no_seq")
	private Long guestNo;
	
	private String guestName;
	
//	@Column(columnDefinition = "date default sysdate") // default 설정 (이렇게도 가능)
	@ColumnDefault(value = "sysdate") // default 설정
	@CreationTimestamp // JPA insert시 현재 시각 자동 삽입 (update 시: UpdateTimeStamp)
	private Date guestDate;
	
	private String guestEmail;
	private String guestHomepage;
	private String guestTitle;
	private String guestContent;
}
