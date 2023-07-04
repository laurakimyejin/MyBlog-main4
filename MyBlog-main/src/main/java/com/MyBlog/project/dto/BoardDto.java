package com.MyBlog.project.dto;

import com.MyBlog.project.model.Board;
import com.MyBlog.project.model.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDto {
	
	private Long id;
	
	@NonNull
	private String audioFile;
    private String content;
    private String declaration;
    private char disData;
    private User user;
    
    public Board toEntity() {
    	return Board.builder()
    			.id(id)
    			.audioFile(audioFile)
    			.content(content)
    			.declaration(declaration)
    			.disData(disData)
    			.user(user)
    			.build();
    }
    
    //생성자
    public BoardDto toDto(Board board) {
    	this.id = board.getId();
    	this.audioFile = board.getAudioFile();
    	 this.content = board.getContent();
         this.declaration = board.getDeclaration();
         this.disData = board.getDisData();
         this.user = board.getUser();
         return this;
    }
    
}
