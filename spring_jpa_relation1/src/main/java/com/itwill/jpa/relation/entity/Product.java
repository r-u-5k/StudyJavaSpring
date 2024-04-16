package com.itwill.jpa.relation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	@SequenceGenerator(name = "product_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; // PK

	private String name;
	private Integer price;
	private Integer stock;

	/*
	 * N (Product) : 1 (Category)
	 * OWNER TABLE
	 */
	@ManyToOne(cascade = CascadeType.PERSIST)
	@ToString.Exclude
	private Category category;

	/*
	 * 1 (Product) : 1 (ProductDetail)
	 * OWNER TABLE (X)
	 */
	@OneToOne(mappedBy = "product")
	private ProductDetail productDetail; // FK
}
