package dao.address;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
/*
 * VO(Value Object),DTO(Data Transfer Object)
 * 	- address 테이블 1개 row의 데이터의 값을 가지는 객체
 *  - address 테이블 1개 row의 데이터값을 전달(파라미터, 리턴데이터)시키기 위한 객체
 *  - address 테이블의 컬럼과 동일한 수의 멤버 필드를 가지는 객체
 */


public class Address {
	private int no;
	private String name;
	private String phone;
	private String address;
}
