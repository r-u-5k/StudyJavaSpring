package dao.address;

public class AddressSQL {
	public static final String ADDRESS_INSERT = "INSERT INTO ADDRESS VALUES(ADDRESS_NO_SEQ.NEXTVAL, ?, ?, ?)";
	public static final String ADDRESS_UPDATE = "UPDATE ADDRESS SET NAME = ?, PHONE = ?, ADDRESS = ? WHERE NO = ?";
	public static final String ADDRESS_DELETE = "DELETE FROM ADDRESS WHERE NO = ?";
	public static final String ADDRESS_SELECT_BY_NO = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS WHERE NO = ?";
	public static final String ADDRESS_SELECT_ALL = "SELECT NO, NAME, PHONE, ADDRESS FROM ADDRESS";
}
