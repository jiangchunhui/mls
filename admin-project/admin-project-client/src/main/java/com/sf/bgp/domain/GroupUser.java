package com.sf.bgp.domain;

import java.io.Serializable;
import java.util.Date;

public class GroupUser implements Serializable{
	private long id;
	private long group_id; //
	private long user_id;//
	private String address_1;//
	private String address_2;//
	private String name;//
	private String mobile;//
	private int expect_sum;//
	private double avg_weight;//
	private Date created_time;//
	private Date modifed_time;//

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getGroup_id() {
		return group_id;
	}

	public void setGroup_id(long group_id) {
		this.group_id = group_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getExpect_sum() {
		return expect_sum;
	}

	public void setExpect_sum(int expect_sum) {
		this.expect_sum = expect_sum;
	}

	public double getAvg_weight() {
		return avg_weight;
	}

	public void setAvg_weight(double avg_weight) {
		this.avg_weight = avg_weight;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Date getModifed_time() {
		return modifed_time;
	}

	public void setModifed_time(Date modifed_time) {
		this.modifed_time = modifed_time;
	}
}
