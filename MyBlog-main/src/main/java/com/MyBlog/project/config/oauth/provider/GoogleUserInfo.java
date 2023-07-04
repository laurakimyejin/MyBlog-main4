package com.MyBlog.project.config.oauth.provider;

import java.util.Map;

public class GoogleUserInfo implements OAuth2UserInfo {
	
	private Map<String, Object> attributes;
	
	public GoogleUserInfo(Map<String, Object> attributes) {
		this.attributes = attributes;
	}

	@Override
	public String getProviderID() {
		return (String) attributes.get("sub");
	}

    @Override
    public String getProvider() {
        return "google";
    }

    @Override
    public String getPhoneNumber() { return (String) attributes.get("phoneNumber");
    }

    @Override
    public String getName() {
        return (String) attributes.get("username");
    }

}
