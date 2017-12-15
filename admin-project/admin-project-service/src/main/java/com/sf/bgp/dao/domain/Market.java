package com.sf.bgp.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class Market implements Serializable{
	private long id;
	private String mkt_id;
	private String mkt_name_show;
	private int daily_min_packages;
	private double weight_min;
	private double weight_max;
	private double base_price;
	private double base_weight;
	private int group_limit;
	private int group_duration;
	private String use_require;
	private String banner;
	private Date created_time;
	private Date modifed_time;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMkt_id() {
		return mkt_id;
	}

	public void setMkt_id(String mkt_id) {
		this.mkt_id = mkt_id;
	}

	public String getMkt_name_show() {
		return mkt_name_show;
	}

	public void setMkt_name_show(String mkt_name_show) {
		this.mkt_name_show = mkt_name_show;
	}

	public int getDaily_min_packages() {
		return daily_min_packages;
	}

	public void setDaily_min_packages(int daily_min_packages) {
		this.daily_min_packages = daily_min_packages;
	}

	public double getWeight_min() {
		return weight_min;
	}

	public void setWeight_min(double weight_min) {
		this.weight_min = weight_min;
	}

	public double getWeight_max() {
		return weight_max;
	}

	public void setWeight_max(double weight_max) {
		this.weight_max = weight_max;
	}

	public double getBase_price() {
		return base_price;
	}

	public void setBase_price(double base_price) {
		this.base_price = base_price;
	}

	public double getBase_weight() {
		return base_weight;
	}

	public void setBase_weight(double base_weight) {
		this.base_weight = base_weight;
	}

	public int getGroup_limit() {
		return group_limit;
	}

	public void setGroup_limit(int group_limit) {
		this.group_limit = group_limit;
	}

	public int getGroup_duration() {
		return group_duration;
	}

	public void setGroup_duration(int group_duration) {
		this.group_duration = group_duration;
	}

	public String getUse_require() {
		return use_require;
	}

	public void setUse_require(String use_require) {
		this.use_require = use_require;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
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
