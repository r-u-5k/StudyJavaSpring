package dao.address;

import java.util.List;

public class AddressDaoTestMain {

	public static void main(String[] args) throws Exception {
		AddressDao addressDao3 = new AddressDao();
		
		System.out.println("1. insert");
		Address address = new Address(0, "김수미", "666-6666", "광주시");
		System.out.println(">> Insert Row Count: " + addressDao3.insert(address));
		
		System.out.println("2. updateByNo");
		Address updateAddress = new Address(10, "텐수정", "100-1000", "텐네시");
		System.out.println(">> Update Row Count: " + addressDao3.updateByNo(updateAddress));
		System.out.println(">> Update Row Count: " + addressDao3.updateByNo(new Address(18, "열여덟", "181-1818", "제주도")));
		
		System.out.println("3. deleteByNo");
		System.out.println(">> Delete Row Count: " + addressDao3.deleteByNo(22));
		
		System.out.println("4. selectByNo");
		Address findAddress = addressDao3.selectByNo(25);
		System.out.println(findAddress);
		
		System.out.println("5. selectAll");
		List<Address> addressList = addressDao3.selectAll();
		for (Address addresses : addressList) {
			System.out.println(addresses);
		}
	}

}
