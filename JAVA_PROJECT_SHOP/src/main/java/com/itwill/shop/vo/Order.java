package com.itwill.shop.vo;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {
	private int oNo;
	private String oDesc;
	private Date oDate;
	private int oPrice;
	private User user;
	
	/*
	 * Order : OrderItem = 1 : n
	 */
	private List<OrderItem> orderItemList;
}
