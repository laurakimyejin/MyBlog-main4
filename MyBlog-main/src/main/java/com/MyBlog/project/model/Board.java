package com.MyBlog.project.model;

import javax.persistence.*;

import com.MyBlog.project.dto.BoardDto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
public class Board extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//판별값
	@Column(nullable = false)
	private char disData;

	//파일명
	@Column(nullable = false, length = 60)
	private String audioFile;

	//신고된 전화번호
	@Column(nullable = false, length = 40)
	private String declaration;
	
//	@Column(nullable = false)
//	private String category;
	
	@Lob // 대용량 데이터
	private String content;

	
	//조회수
//	@Column(nullable =false)
//	private int views;
	
	@ManyToOne(fetch = FetchType.LAZY) //EAGER=호출시 바로 로드
    @JoinColumn(name = "userId") //DB상 필드값은 userId로 설정
    private User user;
	
//	public void updateBoard(String title, String content, String category) {
//		this.audioFile = audioFile;
//		this.content = content;
//		this.category = category;
//	}
	
	public BoardDto toDto() {
		return BoardDto.builder()
                .id(id)
                .audioFile(audioFile)
                .content(content)
                .disData(disData)
                .declaration(declaration)
                .user(user)
                .build();
	}
}
