package com.itwill.jdbc.dao.board;
/*
VO(Value Object),DTO(Data Transfer Object)
	- board 테이블 1개 row의 데이타의 값을 가지는객체
	- board 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- board 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
이름               널?       유형             
---------------- -------- -------------- 
BOARD_NO         NOT NULL NUMBER(10)     
BOARD_TITLE               VARCHAR2(255)  
BOARD_CONTENT             VARCHAR2(4000) 
BOARD_WDAY                DATE           
BOARD_READ_COUNT          NUMBER(10)     
 */
public class Board {
	private int board_no;
	private String board_title;
	private String board_content;
	private String board_wday;
	private int board_read_count;
}