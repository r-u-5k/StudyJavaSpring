package com.itwill.user;

public class UserSQL {
	public final static String USER_INSERT = "INSERT INTO USERINFO (USERID, PASSWORD, NAME, EMAIL) VALUES (?, ?, ?, ?)";
	public final static String USER_UPDATE = "UPDATE USERINFO SET PASSWORD = ?,NAME = ?, EMAIL = ? WHERE USERID = ?";
	public final static String USER_REMOVE = "DELETE USERINFO WHERE USERID = ?";
	public final static String USER_SELECT_BY_ID = "SELECT USERID, PASSWORD, NAME, EMAIL FROM USERINFO WHERE USERID = ?";
	public final static String USER_SELECT_ALL = "SELECT USERID, PASSWORD, NAME, EMAIL FROM USERINFO;";
	public final static String USER_SELECT_BY_ID_COUNT = "SELECT COUNT(*) CNT FROM USERINFO WHERE USERID = ?";
}
