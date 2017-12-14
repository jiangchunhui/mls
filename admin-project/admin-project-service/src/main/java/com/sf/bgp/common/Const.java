package com.sf.bgp.common;

/**
 * @author wujiang
 * @version 1.0.0
 * @date 2017/11/27
 */
public interface Const {
    String UNDERLINE = "_";

    //网关常量
    String GWNAME = "GwName_";
    String GWNAMESTATUS = "GwNameStatus_";
    String APPKEYPATH = "AppkeyPath_";
    String ADDR = "addr_";
    String APPKEY = "appkey_";
    String FIRSTPATH = "firstpath_";
    String SECONDPATH = "secondpath_";
    String SECONDADDR = "secondaddr_";
    int GWEXPIRETIME = 3600*2;

    //推送常量
    int PUSHEXPIRETIME = 3600*24*2;
}
