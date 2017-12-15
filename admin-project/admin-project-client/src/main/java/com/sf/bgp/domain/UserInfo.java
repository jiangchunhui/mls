package com.sf.bgp.domain;

import java.io.Serializable;

public class UserInfo implements Serializable {
	private String username; // 用户名

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
