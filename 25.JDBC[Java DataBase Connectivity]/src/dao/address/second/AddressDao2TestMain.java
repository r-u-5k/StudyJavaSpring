package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception {
		AddressDao2 addressDao2 = new AddressDao2();
		System.out.println("1. insert");
		addressDao2.insert();
		System.out.println("2. updateByNo");
		addressDao2.updateByNo();
		System.out.println("3. deleteByNo");
		addressDao2.deleteByNo();
		System.out.println("4. selectByNo");
		addressDao2.selectByNo();
		System.out.println("5. selectAll");
		addressDao2.selectAll();
		
	}

}
