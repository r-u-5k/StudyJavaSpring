DROP TABLE ADDRESS CASCADE CONSTRAINTS;

CREATE TABLE ADDRESS(
		NO                            		NUMBER(10)		 NULL ,
		NAME                          		VARCHAR2(50)		 NULL ,
		PHONE                         		VARCHAR2(50)		 NOT NULL,
		ADDRESS                       		VARCHAR2(10)		 DEFAULT '서울시'		 NOT NULL 
);



ALTER TABLE ADDRESS ADD CONSTRAINT IDX_ADDRESS_PK PRIMARY KEY (NO);

