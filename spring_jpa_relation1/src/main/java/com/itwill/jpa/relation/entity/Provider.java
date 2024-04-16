package com.itwill.jpa.relation.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity(name = "provider")
public class Provider {
	@Id
	@SequenceGenerator(name = "provider_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "provider_seq")
	private Long id;
	private String name;
	/*
	 * 1 (Provider) : N (Product)
	 * OWNER TABLE (X)
	 */
	@OneToMany(mappedBy = "provider", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.EAGER)
	@ToString.Exclude
	@Builder.Default
	private List<Product> products = new ArrayList<>();
}
