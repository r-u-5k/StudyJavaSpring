package com.itwill.jpa.relation.entity;

import jakarta.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_seq")
	private Long id; // PK

	private String name;
	private Integer price;
	private Integer stock;

	/*
	 * N (Product) : 1 (Provider)
	 * OWNER TABLE
	 */
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "provider_id")
	@ToString.Exclude
	private Provider provider;

	/*
	 * 1 (Product) : 1 (ProductDetail)
	 * OWNER TABLE (X)
	 */
	@OneToOne(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
	@ToString.Exclude
	private ProductDetail productDetail; // FK

	/*
	 * N (Product) : 1 (Category)
	 * OWNER TABLE
	 */
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn
	@ToString.Exclude
	private Category category; // FK

}
