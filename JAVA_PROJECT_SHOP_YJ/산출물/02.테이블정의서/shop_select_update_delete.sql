/***************회원******************/
--회원정보보기(select pk)
SELECT * FROM USERINFO WHERE USERID='yj9900';

--회원정보수정(update pk)
UPDATE USERINFO SET PASSWORD='1111',NAME='김변경',EMAIL='change@naver.com' WHERE USERID='yj9900';

--회원탈퇴(delete pk)
DELETE USERINFO WHERE USERID='yj9900';

/****************제품*****************/
--제품전체리스트
SELECT * FROM PRODUCT;
--제품상세보기
SELECT * FROM PRODUCT WHERE P_NO=1;
--제품수정(X)
--제품삭제(X)
--제품추가(X)

/***********************카트************************/
--로그인한 멤버(guard1)의 카트 리스트
SELECT * FROM CART WHERE USERID = 'yj9900';
SELECT C.*, P.*, C.cart_qty * P.p_price "아이템가격" FROM CART C JOIN PRODUCT P
ON C.P_NO = P.P_NO
WHERE USERID = 'yj9900';

--로그인한 멤버(yj9900)의 카트 리스트 삭제
DELETE FROM CART WHERE USERID = 'yj9900';
COMMIT;

--로그인한 멤버(yj9900)의 카트 아이템 1개 삭제
DELETE FROM CART WHERE CART_NO = 9;

--로그인한 멤버(yj9900)의 카트 1개 아이템 수량 변경
UPDATE CART SET cart_qty = cart_qty + 1 WHERE USERID = 'yj9900' AND P_NO = 1;

--로그인한 멤버(yj9900)의 카트에 존재하는 제품의 수(제품존재여부판단)
SELECT COUNT(*) AS P_COUNT FROM CART WHERE USERID = 'yj9900' AND P_NO = 1;

--로그인한 멤버(yj9900)의 카트에 담기(존재하는 상품 수정)
UPDATE CART SET CART_QTY = CART_QTY + 3 WHERE USERID = 'yj9900' AND P_NO = 1;

/****************order********************/
--1.멤버한사람의 주문전체목록(yj9900)
SELECT * FROM ORDERS WHERE USERID = 'yj9900';

--1.멤버한사람의 주문(주문아이템+제품)전체목록(yj9900)
SELECT * FROM ORDERS O JOIN ORDER_ITEM OI
ON O.O_NO = OI.OI_NO JOIN PRODUCT P
ON OI.P_NO = P.P_NO
WHERE USERID = 'yj9900';

--2.멤버한사람의 주문(주문아이템+제품)한개(yj9900)
SELECT * FROM ORDERS O JOIN ORDER_ITEM OI 
ON o.o_no = oi.oi_no JOIN PRODUCT P
ON oi.p_no = p.p_no
WHERE O.O_NO = 1;

--3.로그인한멤버(yj9900)주문한개삭제
-- on delete cascade
DELETE FROM ORDERS WHERE O_NO = 1 AND USERID = 'yj9900';

--4. 로그인한멤버(yj9900)주문전체삭제
DELETE FROM ORDERS WHERE USERID = 'yj9900';