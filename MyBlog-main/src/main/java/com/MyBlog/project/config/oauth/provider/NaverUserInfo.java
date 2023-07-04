package com.MyBlog.project.config.oauth.provider;

import java.util.Map;

public class NaverUserInfo implements OAuth2UserInfo{
	
	private Map<String, Object> attributes;
	
	public NaverUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String getProviderID() {
		return (String) attributes.get("id");
	}

	@Override
	public String getProvider() {
		return "naver";
	}

	@Override
	public String getPhoneNumber() {
		return (String) attributes.get("phoneNumber");
	}

	@Override
	public String getName() {
		return (String) attributes.get("name");
	}

}
