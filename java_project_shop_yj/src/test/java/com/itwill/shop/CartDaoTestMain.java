package com.itwill.shop;

import java.util.List;

import com.itwill.shop.dao.CartDao;
import com.itwill.shop.vo.Cart;
import com.itwill.shop.vo.Product;
import com.itwill.shop.vo.User;

public class CartDaoTestMain {

	public static void main(String[] args) throws Exception {
		CartDao cartDao = new CartDao();
		System.out.println("1.add(insert)");
		/*
		int insertRowCount = cartDao.insert(Cart.builder()
											    .user(User.builder().userid("yj9900").build())
											    .product(Product.builder().pNo(5).build())
											    .cartQty(3)
											    .build());
		*/

		System.out.println("2.updateByCartNo");
		System.out.println(cartDao.updateByCartNo(Cart.builder().cartNo(6).cartQty(10).build()));

		System.out.println("2.updateByProductNo");
		System.out.println(cartDao.updateByProductNo(Cart.builder()
														 .product(Product.builder().pNo(1).build())
														 .user(User.builder().userid("yj9900").build())
														 .cartQty(5)
														 .build())); 
		

		System.out.println("3.delete");
		

		System.out.println("4.cartList[select]");
		List<Cart> cartList1 = cartDao.findByUserId("yj9900");
		System.out.println(cartList1);
		
		System.out.println("5.countByProductNo");
		System.out.println(cartDao.countByProductNo("yj9900", 1));

	}
}
