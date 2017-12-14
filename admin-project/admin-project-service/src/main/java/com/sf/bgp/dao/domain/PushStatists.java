package com.sf.bgp.dao.domain;

import java.util.Date;

/**
 * 推送统计到达率实体类
 */
public class PushStatists {
	private static final long serialVersionUID = 378987478870550393L;

	private Long id;
	private Long statDate;
	private Integer appId;
	private Integer totalCount;//总数量
	private Integer s1Count;
	private Integer s3Count;
	private Integer s5Count;
	private Integer s30Count;
	private Integer s60Count;
	private Integer otherCount;
	private Date createTime;//创建时间

	public PushStatists(){

	}

	public PushStatists(Long statDate, Integer appId, Integer totalCount, Integer s1Count, Integer s3Count, Integer s5Count, Integer s30Count, Integer s60Count, Integer otherCount, Date createTime) {
		this.statDate = statDate;
		this.appId = appId;
		this.totalCount = totalCount;
		this.s1Count = s1Count;
		this.s3Count = s3Count;
		this.s5Count = s5Count;
		this.s30Count = s30Count;
		this.s60Count = s60Count;
		this.otherCount = otherCount;
		this.createTime = createTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStatDate() {
		return statDate;
	}

	public void setStatDate(Long statDate) {
		this.statDate = statDate;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getS1Count() {
		return s1Count;
	}

	public void setS1Count(Integer s1Count) {
		this.s1Count = s1Count;
	}

	public Integer getS3Count() {
		return s3Count;
	}

	public void setS3Count(Integer s3Count) {
		this.s3Count = s3Count;
	}

	public Integer getS5Count() {
		return s5Count;
	}

	public void setS5Count(Integer s5Count) {
		this.s5Count = s5Count;
	}

	public Integer getS30Count() {
		return s30Count;
	}

	public void setS30Count(Integer s30Count) {
		this.s30Count = s30Count;
	}

	public Integer getS60Count() {
		return s60Count;
	}

	public void setS60Count(Integer s60Count) {
		this.s60Count = s60Count;
	}

	public Integer getOtherCount() {
		return otherCount;
	}

	public void setOtherCount(Integer otherCount) {
		this.otherCount = otherCount;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
