package com.itwill.address.servlet;

import java.io.IOException;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddressUpdateActionServlet
 */
@WebServlet("/address_update_action")
public class AddressUpdateActionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("address_list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/**
			 * 0.요청객체 encoding설정
			 * 1.파라메타 바끼(no,name,phone,address)
			 * 2.파라메타데이타로 Address객체생성
			 * 3.AddressService객체생성 
			 * 4.AddressService.update()메쏘드실행 
			 * 5.adress_detail로 redirection
			 */
			request.setCharacterEncoding("UTF-8");
			String noStr = request.getParameter("no");
			if (noStr == null || noStr.equals("")) {
				response.sendRedirect("address_list");
				return;
			}
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String address = request.getParameter("address");
			Address updateAddress = Address.builder().no(Integer.parseInt(noStr))
													 .name(name)
													 .phone(phone)
													 .address(address)
													 .build();
			
			AddressService addressService = new AddressService();
			addressService.addressUpdate(updateAddress);
			
			response.sendRedirect("address_detail?no=" + noStr);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}