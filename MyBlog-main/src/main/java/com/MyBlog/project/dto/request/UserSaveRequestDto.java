package com.MyBlog.project.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.MyBlog.project.model.RoleType;
import com.MyBlog.project.model.User;

import lombok.Builder;
import lombok.Data;

@Data
public class UserSaveRequestDto {
    @NotBlank
    @Size(min = 4, max = 12)
    @NotEmpty(message = "아이디 입력은 필수 입니다.")
    private String username;

    @NotEmpty
    //@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password;

    @NotEmpty
    //@Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String password2;

    @NotEmpty(message = "전화번호 입력은 필수 입니다.")
    //@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private String phoneNumber;
    private RoleType rating;
	
    //디폴트 생성자가 있어야지 바인딩 되는데 원래 코드에는 없음....
    public UserSaveRequestDto() {};
    
	@Builder
	public UserSaveRequestDto(String username, String password, String phoneNumber, RoleType roleType) {
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.rating = roleType;
	}
	
	public User toEntity() {
		return User.builder()
				   .username(username)
				   .password(password)
				   .phoneNumber(phoneNumber)
				   .rating(rating)
				   .build();
	}
}
