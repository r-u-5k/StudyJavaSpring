package com.itwill.guest;

public class GuestSQL {
	public static final String GUEST_INSERT = "INSERT INTO GUEST VALUES (GUEST_GUEST_NO_SEQ.NEXTVAL, ?, SYSDATE, ?, ?, ?, ?)";
	public static final String GUEST_UPDATE = "UPDATE GUEST SET GUEST_NAME = ?, GUEST_DATE = SYSDATE, GUEST_EMAIL = ?, GUEST_HOMEPAGE = ?, GUEST_TITLE = ?, GUEST_CONTENT = ? WHERE GUEST_NO = ?";
	public static final String GUEST_DELETE = "DELETE FROM GUEST WHERE GUEST_NO = ?";
	public static final String GUEST_SELECT_BY_NO = "SELECT * FROM GUEST WHERE GUEST_NO = ?";
	public static final String GUEST_SELECT_BY_NAME = "SELECT * FROM GUEST WHERE GUEST_NAME = ?";
	public static final String GUEST_SELECT_ALL = "SELECT * FROM GUEST";
}
