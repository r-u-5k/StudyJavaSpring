package com.itwill.jpa.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@DynamicUpdate
@DynamicInsert
@Entity(name = "user")
@Table(name = "userinfo")
public class User {
	@Id
	@Column(name = "userid")
	private String userId;
	
	@Column(length = 100, nullable = false)
	private String password;
	
	private String name;
	private String email;
}
