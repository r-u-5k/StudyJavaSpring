--guest
/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME              VARCHAR2(50)   
GUEST_DATE              DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE             VARCHAR2(100)  
GUEST_CONTENT           VARCHAR2(4000) 
*/
DESC GUEST;

--insert

INSERT INTO GUEST VALUES (
    GUEST_GUEST_NO_SEQ.NEXTVAL,
    '김경호',
    SYSDATE,
    'guard1@gmail.com',
    'http://www.itwill.co.kr',
    '방명록사용법1',
    '방명록처럼 사용하시면됩니다1.'
);

INSERT INTO GUEST VALUES (
    GUEST_GUEST_NO_SEQ.NEXTVAL,
    '정경호',
    SYSDATE,
    'guard2@gmail.com',
    'http://www.itwill.co.kr',
    '방명록사용법2',
    '방명록처럼 사용하시면됩니다2.'
);

INSERT INTO GUEST VALUES (
    GUEST_GUEST_NO_SEQ.NEXTVAL,
    '심경호',
    SYSDATE,
    'guard3@gmail.com',
    'http://www.itwill.co.kr',
    '방명록사용법3',
    '방명록처럼 사용하시면됩니다3.'
);

INSERT INTO GUEST VALUES (
    GUEST_GUEST_NO_SEQ.NEXTVAL,
    '김경호',
    SYSDATE,
    'guard4@gmail.com',
    'http://www.itwill.co.kr',
    '방명록사용법4',
    '방명록처럼 사용하시면됩니다4.'
);
--pk update
UPDATE GUEST SET GUEST_NAME = '이름수정',
    			 GUEST_DATE = SYSDATE,
    			 GUEST_EMAIL = 'change@gmail.com',
    			 GUEST_HOMEPAGE = 'http://www.change.com',
    			 GUEST_TITLE = '타이틀변경',
    			 GUEST_CONTENT = '내용변경'
WHERE GUEST_NO = 1;

--pk delete 
DELETE FROM GUEST WHERE GUEST_NO = 1;
--pk select
SELECT * FROM GUEST WHERE GUEST_NO = 2;
--name select
SELECT * FROM GUEST WHERE GUEST_NAME = '김경호';
--select * from guest where guest_name like '%'||'경호'||'%';
--all select
SELECT * FROM GUEST;