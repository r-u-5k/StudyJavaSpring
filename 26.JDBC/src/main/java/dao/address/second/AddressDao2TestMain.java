package dao.address.second;

public class AddressDao2TestMain {

	public static void main(String[] args) throws Exception {
		AddressDao2 addressDao2 = new AddressDao2();
		System.out.println("1. insert");
		addressDao2.insert("이소라", "654-5413", "서울시");
		addressDao2.insert("삼소라", "123-8989", "강릉시");
		System.out.println("2. updateByNo");
		addressDao2.updateByNo(10, "채인지", "111-1111", "대전시");
		System.out.println("3. deleteByNo");
		addressDao2.deleteByNo(22);
		System.out.println("4. selectByNo");
		addressDao2.selectByNo(25);
		System.out.println("5. selectAll");
		addressDao2.selectAll();
	}

}
