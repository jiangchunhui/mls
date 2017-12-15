package com.sf.bgp.dao.domain;

import java.io.Serializable;
import java.util.Date;

public class Group implements Serializable{
	private long id;
	private String market_id; // 用户名
	private String group_name;//集货团显示名
	private int current_count;//当前数量
	private Date start_time;//开始时间
	private Date end_time;//结束时间
	private String banner;//展示图片
	private int finish;//是否完成
	private Date created_time;//创建时间
	private Date modifed_time;//修改时间

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMarket_id() {
		return market_id;
	}

	public void setMarket_id(String market_id) {
		this.market_id = market_id;
	}

	public String getGroup_name() {
		return group_name;
	}

	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}

	public int getCurrent_count() {
		return current_count;
	}

	public void setCurrent_count(int current_count) {
		this.current_count = current_count;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public int getFinish() {
		return finish;
	}

	public void setFinish(int finish) {
		this.finish = finish;
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
