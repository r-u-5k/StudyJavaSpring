package com.itwill.address.test;

import com.itwill.address.Address;
import com.itwill.address.AddressService;

public class AddressServiceTestMain {

	public static void main(String[] args) throws Exception {
		AddressService addressService = new AddressService();
		System.out.println("1. 주소록 전체보기");
		System.out.println(addressService.addressList());
		
		System.out.println("2. 주소록 상세보기");
		System.out.println(addressService.addressDetail(11));
		
		System.out.println("3. 주소록 수정");
		Address updateAddress = addressService.addressDetail(12);
		System.out.println(updateAddress);
		updateAddress.setName("이름변경");
		updateAddress.setPhone("000-0000");
		System.out.println(">> Update Row Count: " + addressService.addressUpdate(updateAddress));
	
		System.out.println("4. 주소록 삭제");
		System.out.println(">> Delete Row Count: " + addressService.addressDelete(13));
		
		System.out.println("5. 주소록 쓰기");
		System.out.println(">> Insert Row Count: " + addressService.addressWrite(new Address(0, "이름추가", "000-0000", "주소추가")));
		
	}

}
