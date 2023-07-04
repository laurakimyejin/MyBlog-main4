package com.MyBlog.project.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.MyBlog.project.model.User;

import lombok.Builder;

public class UserUpdateDto {
	
	private Long id;
	private String username;
	
	@NotBlank
	private String password;
	
	@NotEmpty(message = "전화번호 입력은 필수입니다.")
	private String phoneNumber;
	
	@Builder
	public UserUpdateDto(Long id, String username, String password, String phoneNumber) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public User toEntity() {
		return User.builder()
				   .id(id)
				   .username(username)
				   .password(password)
				   .phoneNumber(phoneNumber)
				   .build();
	}
}
