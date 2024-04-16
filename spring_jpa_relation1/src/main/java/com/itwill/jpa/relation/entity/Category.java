package com.itwill.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category {
	@Id
	@SequenceGenerator(name = "category_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; // PK

	@Column(unique = true, nullable = false)
	private String code;

	private String name;

	/*
	 * 1 (Category) : N (Product)
	 * OWNER TABLE (X)
	 */
	@OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
	@Builder.Default
	@ToString.Exclude
	private List<Product> products = new ArrayList<>(); // FK

}
