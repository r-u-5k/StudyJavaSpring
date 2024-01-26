package com.itwill.member;
/*
insert into member(member_id,member_password,member_name,member_address,member_age,member_married,member_regdate) values('aaaa','aaaa','김경수','부산시 영도구',37,'F',sysdate);
update member set  member_password='0000', member_name='김변경', member_address='제주도민', member_age=20,member_married='T',member_regdate=sysdate where member_id='aaaa';
delete from member where member_id='aaaa';
select member_id,member_password,member_name,member_address,member_age,member_married,member_regdate from member where member_id='bbbb';
select member_id,member_password,member_name,member_address,member_age,member_married,member_regdate from member;
*/
public class MemberSQL {
	public static final String  MEMBER_INSERT=
		"INSERT INTO MEMBER(MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_ADDRESS, MEMBER_AGE, MEMBER_MARRIED, MEMBER_REGDATE) VALUES(?,?,?,?,?,?,SYSDATE)";
	public static final String  MEMBER_UPDATE=
		"UPDATE MEMBER SET MEMBER_PASSWORD=?, MEMBER_NAME=?, MEMBER_ADDRESS=?, MEMBER_AGE=?, MEMBER_MARRIED=? WHERE MEMBER_ID=?";
	public static final String  MEMBER_DELETE=
		"DELETE FROM MEMBER WHERE MEMBER_ID=?";
	public static final String  MEMBER_SELECT_BY_ID=
		"SELECT MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_ADDRESS, MEMBER_AGE, MEMBER_MARRIED, MEMBER_REGDATE FROM MEMBER WHERE MEMBER_ID=?";
	public static final String  MEMBER_SELECT_ALL=
		"SELECT MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_ADDRESS, MEMBER_AGE, MEMBER_MARRIED, MEMBER_REGDATE FROM MEMBER";
}
