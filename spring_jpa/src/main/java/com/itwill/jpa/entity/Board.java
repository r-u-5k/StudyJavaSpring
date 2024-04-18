package com.itwill.jpa.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

@SequenceGenerator(name = "board_boardno_seq", sequenceName = "board_boardno_seq", initialValue = 1, allocationSize = 1)
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_boardno_seq")
	private Long boardno;

	private String title;
	private String writer;
	private String content;

	@Column(updatable = false)
	@ColumnDefault("sysdate")
	@CreationTimestamp
	private LocalDateTime regdate;

	@ColumnDefault("0")
	private Long readcount;

	@ColumnDefault("0")
	private Long groupno;

	@ColumnDefault("1")
	private Long step;

	@ColumnDefault("0")
	private Long depth;
}
