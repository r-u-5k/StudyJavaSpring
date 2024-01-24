DROP TABLE PRODUCT;

CREATE TABLE PRODUCT (
    NO         NUMBER(7) PRIMARY KEY,
    NAME       VARCHAR2(50),
    SHORT_DESC VARCHAR2(255),
    PRICE      NUMBER(10, 3),
    IPGO_DATE  DATE
);

INSERT INTO PRODUCT VALUES (
    10011,
    '명품플러스원',
    '한글자막 안내기능',
    4000.123,
    TO_DATE('17/12/24', 'YY/MM/DD')
);

INSERT INTO PRODUCT VALUES (
    10012,
    '장수명브라운관',
    '브라운관 수명3배',
    3000.1234,
    TO_DATE('2017/12/24', 'YYYY/MM/DD')
);

INSERT INTO PRODUCT VALUES (
    10021,
    '액정와이드프로젝션',
    '고화질시네마비젼',
    3000,
    TO_DATE('2017/12/24', 'yyyy/mm/dd')
);

INSERT INTO PRODUCT VALUES (
    10022,
    '액정와이드프로젝션2',
    '고화질시네마비젼2',
    4000.5,
    SYSDATE
);

COMMIT;

INSERT INTO PRODUCT (
    NO,
    NAME,
    SHORT_DESC,
    PRICE,
    IPGO_DATE
) VALUES (
    10023,
    'GALAXYS9',
    '아주좋아요',
    90000,
    SYSDATE
);

INSERT INTO PRODUCT (
    NO,
    NAME,
    SHORT_DESC,
    PRICE,
    IPGO_DATE
) VALUES (
    10024,
    'GALAXYS9+',
    '아주아주좋아요',
    100000,
    TO_DATE('2018/05/22', 'YYYY/MM/DD')
);

/*
DROP SEQUENCE PRODUCT_NO_SEQ;
CREATE SEQUENCE  PRODUCT_NO_SEQ  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 20000 NOCACHE  NOORDER  NOCYCLE ;

insert into product(no,name,short_desc,price,ipgo_date)
values(product_no_seq.nextval,'GALAXYS NOTE8','진짜좋아요',99999.99,sysdate);
*/

/******************java***********************************
insert into product(no,name,short_desc,price,ipgo_date)
values(?,?,?,?,sysdate);

insert into product(no,name,short_desc,price,ipgo_date)
values(?,?,?,?,?);

insert into product(no,name,short_desc,price,ipgo_date)
values(?,?,?,?,to_date(?,'YYYY/MM/DD'));

insert into product(no,name,short_desc,price,ipgo_date)
values(?,?,?,?,to_date(?,?));
**********************************************************/
COMMIT;

DESC PRODUCT;

SELECT
	NO,
    NAME,
    SHORT_DESC,
    IPGO_DATE
FROM
    PRODUCT;

SELECT
    NO,
    NAME,
    SHORT_DESC,
    TO_CHAR(IPGO_DATE, 'YYYY/MM/DD SS')
FROM
    PRODUCT;
    
