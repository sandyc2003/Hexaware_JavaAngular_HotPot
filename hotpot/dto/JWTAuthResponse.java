package com.hexaware.hotpot.dto;

public class JWTAuthResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private UserDto userDto;
	public JWTAuthResponse() {	}
	public JWTAuthResponse(String accessToken, UserDto userDto) {
		super();
		this.accessToken = accessToken;
		this.userDto = userDto;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	public UserDto getUserDto() {
		return userDto;
	}
	public void setUserDto(UserDto userDto) {
		this.userDto = userDto;
	}
	@Override
	public String toString() {
		return "JWTAuthResponse [accessToken=" + accessToken + ", tokenType=" + tokenType + ", userDto=" + userDto
				+ "]";
	}
	
	}

