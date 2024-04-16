package com.itwill.jpa.relation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class ProductDetail {
	@Id
	@SequenceGenerator(name = "product_detail_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_detail_seq")
	private Long id; // PK

	private String description;

	/*
	 * 1 (ProductDetail) : 1 (Product)
	 * OWNER TABLE
	 */
	@OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@ToString.Exclude
	@Builder.Default
	private Product product = new Product(); // FK
}
