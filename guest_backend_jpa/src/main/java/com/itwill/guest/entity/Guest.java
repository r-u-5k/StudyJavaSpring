package com.itwill.guest.entity;

import com.itwill.guest.dto.GuestDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@EqualsAndHashCode

@DynamicUpdate
@DynamicInsert
@Entity
public class Guest {
	@Id
	@SequenceGenerator(name = "guest_guest_no_seq", sequenceName = "guest_guest_no_seq", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "guest_guest_no_seq")
	private Integer guestNo;
	
	private String guestName;
	
//	@Column(columnDefinition = "date default sysdate") // default 설정 (이렇게도 가능)
	@ColumnDefault(value = "sysdate") // default 설정
	@CreationTimestamp // JPA insert시 현재 시각 자동 삽입 (update 시: UpdateTimeStamp)
	private Date guestDate;
	
	private String guestEmail;
	private String guestHomepage;
	private String guestTitle;
	private String guestContent;

	public static Guest toEntity(GuestDto guestDto) {
		return Guest.builder()
				.guestNo(guestDto.getGuestNo())
				.guestName(guestDto.getGuestName())
				.guestDate(guestDto.getGuestDate())
				.guestEmail(guestDto.getGuestEmail())
				.guestHomepage(guestDto.getGuestHomepage())
				.guestTitle(guestDto.getGuestTitle())
				.guestContent(guestDto.getGuestContent())
				.build();
	}
}
