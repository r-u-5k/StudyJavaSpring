package com.itwill.jpa.relation.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_seq")
	private Long id; // PK

	@Column(unique = true, nullable = false)
	private String code;

	private String name;

	/*
	 * 1 (Category) : N (Product)
	 * OWNER TABLE (X)
	 */
	@OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@Builder.Default
	@ToString.Exclude
	private List<Product> products = new ArrayList<>(); // FK

}
