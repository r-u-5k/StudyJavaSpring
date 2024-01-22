DROP TABLE TABLE_1 CASCADE CONSTRAINTS;

CREATE TABLE TABLE_1(
		BOARD_NO                      		NUMBER(10)		 NULL ,
		BOARD_TITLE                   		VARCHAR2(255)		 NULL ,
		BOARD_CONTENT                 		VARCHAR2(4000)		 NULL ,
		BOARD_WDAY                    		DATE		 DEFAULT SYSDATE		 NULL ,
		BOARD_READ_COUNT              		INTEGER(10)		 DEFAULT 0		 NULL 
);

DROP SEQUENCE TABLE_1_BOARD_READ_COUNT_SEQ;

CREATE SEQUENCE TABLE_1_BOARD_READ_COUNT_SEQ NOMAXVALUE NOCACHE NOORDER NOCYCLE;

CREATE TRIGGER TABLE_1_BOARD_READ_COUNT_TRG
BEFORE INSERT ON TABLE_1
FOR EACH ROW
BEGIN
IF :NEW.BOARD_READ_COUNT IS NOT NULL THEN
  SELECT TABLE_1_BOARD_READ_COUNT_SEQ.NEXTVAL INTO :NEW.BOARD_READ_COUNT FROM DUAL;
END IF;
END;



ALTER TABLE TABLE_1 ADD CONSTRAINT IDX_TABLE_1_PK PRIMARY KEY (BOARD_NO);

