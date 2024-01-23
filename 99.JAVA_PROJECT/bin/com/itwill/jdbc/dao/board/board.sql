
DROP TABLE BOARD;

CREATE TABLE BOARD(
    BOARD_NO NUMBER(10) PRIMARY KEY,
    BOARD_TITLE VARCHAR2(255),
    BOARD_CONTENT VARCHAR2(4000),
    BOARD_WDAY DATE DEFAULT SYSDATE,
    BOARD_READ_COUNT NUMBER(10) DEFAULT 0
);

DROP SEQUENCE BOARD_NO_SEQ;

CREATE SEQUENCE BOARD_NO_SEQ 
                 INCREMENT BY 1
                 START WITH 1
                 NOCYCLE
                 NOCACHE;
                 
                 
--insert
INSERT INTO BOARD(BOARD_NO,BOARD_TITLE,BOARD_CONTENT)
              VALUES(BOARD_NO_SEQ.NEXTVAL, '제목', '내용입니다');
--pk update
UPDATE BOARD SET BOARD_TITLE = '변경타이틀', BOARD_CONTENT = '변경content' WHERE BOARD_NO = 4;
--pk delete
DELETE BOARD WHERE BOARD_NO = 0;
--pk select
SELECT * FROM BOARD WHERE BOARD_NO = 2;
--all select
SELECT * FROM BOARD;
