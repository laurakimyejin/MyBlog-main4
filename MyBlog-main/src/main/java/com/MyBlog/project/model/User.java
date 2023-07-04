package com.MyBlog.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.MyBlog.project.dto.response.UserResponseDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(unique = true, nullable = false, length = 40)
	private String username;
	
	@Column(nullable = false, length = 60)
	private String password;
	
	@Column(nullable = false, length = 60)
	private String phoneNumber;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleType rating;
	
	private String provider;
	private String providerId;
	
	public void updatePhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public void updatePassword(String password) {
		this.password = password;
	}
	
	public void updateRole(RoleType rating) {
		this.rating = rating;
	}
	
    public UserResponseDto toDto() {
        return UserResponseDto.builder()
                .id(id)
                .username(username)
                .password(password)
                .phoneNumber(phoneNumber)
                .build();
    }
    
    @Builder
    public User(long id, String username, String password, String phoneNumber, RoleType rating, String provider, String providerId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.rating = rating;
        this.provider = provider;
        this.providerId = providerId;
    }
}
