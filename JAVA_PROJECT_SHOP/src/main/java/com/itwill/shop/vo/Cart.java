package com.itwill.shop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Cart {
	private int cartNo;
	private int cartQty;
//	private String userid;
	private User user;
//	private int pNo;
	private Product product;
}
