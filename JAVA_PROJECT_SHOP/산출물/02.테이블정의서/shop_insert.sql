-- MEMBER INSERT
INSERT INTO userinfo (userId, password, name, email) VALUES ('yj9900', '1234', '장유진', 'yj999900@gmail.com');
INSERT INTO userinfo (userId, password, name, email) VALUES ('yj1111', '1111', 'INSERT1', 'insert1@gmail.com');
INSERT INTO userinfo (userId, password, name, email) VALUES ('yj2222', '2222', 'INSERT2', 'insert2@gmail.com');
INSERT INTO userinfo (userId, password, name, email) VALUES ('yj3333', '3333', 'INSERT3', 'insert3@gmail.com');

-- PRODUCT INSERT
INSERT INTO product (p_no, p_name, p_price, p_image, p_desc, p_click_count) VALUES (1, '비글', 55000, 'beagle.png', 'beagle', 0);
insert into product values(1, '비글', 550000, 'bigle.png','기타 상세 정보 등...', 0);
insert into product values(2, '달마시안', 500000, 'dalma.jpg','기타 상세 정보 등...', 0);
insert into product values(3, '퍼그', 400000, 'pug.jpg','기타 상세 정보 등...', 0);
insert into product values(4, '페키니즈', 450000, 'pekiniz.png','기타 상세 정보 등...', 0);
insert into product values(5, '포메라니안', 800000, 'pomeranian.jpg','기타 상세 정보 등...', 0);
insert into product values(6, '샤페이', 700000, 'shaipei.jpg','기타 상세 정보 등...', 0);
insert into product values(7, '닥스훈트', 800000, 'dachshund.jpg','기타 상세 정보 등...', 0);
insert into product values(8, '사모예드', 800000, 'samoyed.jpg','기타 상세 정보 등...', 0);

-- CART INSERT
INSERT INTO cart (cart_no, userId, p_no, cart_qty) VALUES (cart_cart_no_seq.nextval, 'yj9900', 1, 2);
INSERT INTO cart (cart_no, userId, p_no, cart_qty) VALUES (cart_cart_no_seq.nextval, 'yj9900', 3, 1);
INSERT INTO cart (cart_no, userId, p_no, cart_qty) VALUES (cart_cart_no_seq.nextval, 'yj9900', 7, 4);

-- ORDER INSERT
-- CART 안에 있는 아이템들 주문
-- yj9900 주문
-- ORDERS
INSERT INTO ORDERS (O_NO, O_DESC, O_DATE, O_PRICE, USERID) VALUES (orders_o_no_seq.nextval, '비글외2종', SYSDATE, 1750000, 'yj9900');
-- ORDER_ITEM
INSERT INTO ORDER_ITEM (OI_NO, OI_QTY, O_NO, P_NO) VALUES (order_item_oi_no_seq.nextval, 2, orders_o_no_seq.currval, 1);
INSERT INTO ORDER_ITEM (OI_NO, OI_QTY, O_NO, P_NO) VALUES (order_item_oi_no_seq.nextval, 1, orders_o_no_seq.currval, 3);
INSERT INTO ORDER_ITEM (OI_NO, OI_QTY, O_NO, P_NO) VALUES (order_item_oi_no_seq.nextval, 4, orders_o_no_seq.currval, 7);

-- yj1111 주문 (1번 2개, 3번 1개)
-- ORDERS
INSERT INTO ORDERS (O_NO, O_DESC, O_DATE, O_PRICE, USERID) VALUES (orders_o_no_seq.nextval, '비글외1종', SYSDATE, 950000, 'yj1111');
-- ORDER_ITEM
INSERT INTO ORDER_ITEM (OI_NO, OI_QTY, O_NO, P_NO) VALUES (order_item_oi_no_seq.nextval, 2, orders_o_no_seq.currval, 1);
INSERT INTO ORDER_ITEM (OI_NO, OI_QTY, O_NO, P_NO) VALUES (order_item_oi_no_seq.nextval, 1, orders_o_no_seq.currval, 3);

-- ORDER SELECT
-- 1. 멤버 한 사람의 주문 전체 목록
SELECT * FROM ORDERS WHERE USERID = 'yj9900';
-- 2. 멤버 한 사람의 주문 1개
SELECT * FROM ORDERS WHERE O_NO = 1;
-- 3. 멤버 한 사람의 주문 1개의 주문 아이템 여러 개, 제품 정보
SELECT * FROM ORDERS O JOIN ORDER_ITEM OI 
ON o.o_no = oi.o_no
WHERE O.O_NO = 1;