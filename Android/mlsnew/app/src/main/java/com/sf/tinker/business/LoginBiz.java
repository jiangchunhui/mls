package com.sf.tinker.business;

import com.sf.tinker.entity.LoginUser;

import io.reactivex.Observable;

/**
 * Created by 01243141 on 2017/12/14.
 */

public interface LoginBiz {
    /**
     * 登录
     * @param name
     * @param pwd
     * @return
     */
    Observable<LoginUser> login(String name, String pwd);
}
