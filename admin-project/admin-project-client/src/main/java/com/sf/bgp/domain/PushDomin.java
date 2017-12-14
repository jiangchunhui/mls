package com.sf.bgp.domain;

/**
 * Created by 01304522 on 2017/12/14.
 */
public class PushDomin {
    private static final long serialVsersionUID = -12448888884445555l;
    private String time;
    private int start=0;
    private int pageSize=20;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
