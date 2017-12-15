package com.sf.bgp.dao.domain;

import java.io.Serializable;

public class User implements Serializable{
	private long id;
	private String username; // 用户名
	private String portrait;//头像

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
}
