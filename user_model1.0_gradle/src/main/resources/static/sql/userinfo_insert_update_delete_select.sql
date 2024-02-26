INSERT INTO USERINFO (USERID, PASSWORD, NAME, EMAIL) 
VALUES ('guard1', '1111', '김경호1', 'guard1@korea.com');

INSERT INTO USERINFO (USERID, PASSWORD, NAME, EMAIL) 
VALUES ('guard2', '2222', '김경호2', 'guard2@korea.com');

INSERT INTO USERINFO (USERID, PASSWORD, NAME, EMAIL) 
VALUES ('guard3', '3333', '김경호3', 'guard3@korea.com');

--pk update
UPDATE USERINFO SET PASSWORD = '1111', NAME = '이름변경', EMAIL = 'change@naver.com'
 WHERE USERID = 'guard1';
--pk delete
DELETE USERINFO WHERE USERID = 'guard1';

--select pk
SELECT USERID, PASSWORD, NAME, EMAIL FROM USERINFO WHERE USERID = 'guard2';

--select all
SELECT USERID, PASSWORD, NAME, EMAIL FROM USERINFO;

--select count by userid
SELECT COUNT(*) CNT FROM USERINFO WHERE USERID = 'guard1';

SELECT COUNT(*) CNT FROM USERINFO WHERE USERID = 'guard2';

COMMIT;