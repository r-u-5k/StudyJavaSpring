package com.itwill.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderItem {
	private int oiNo; // PK
	private int oiQty;
//	private int oNo; // FK
	private Order order;
//	private int pNo; // FK
	private Product product;
}
