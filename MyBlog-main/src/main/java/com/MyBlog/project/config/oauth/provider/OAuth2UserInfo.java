package com.MyBlog.project.config.oauth.provider;

public interface OAuth2UserInfo {
    String getProviderID();

    String getProvider();

    String getPhoneNumber();

    String getName();
}
