package com.itwill.jpa.relation.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id; // PK

	private String description;

	/*
	 * 1 (ProductDetail) : 1 (Product)
	 * OWNER TABLE
	 */
	@OneToOne(cascade = CascadeType.PERSIST)
	@ToString.Exclude
	private Product product; // FK
}
