package com.sf.tinker.business;

import com.sf.tinker.constant.HttpConstant;
import com.sf.tinker.entity.LoginUser;
import com.sf.tinker.utils.HttpUtil;

import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.FormBody;

/**
 * Created by 01243141 on 2017/12/14.
 */

public class LoginBizImpl implements LoginBiz {

    @Override
    public Observable<LoginUser> login(final String name, final String pwd) {
        return Observable.create(new ObservableOnSubscribe<LoginUser>() {
            @Override
            public void subscribe(final ObservableEmitter<LoginUser> e) throws Exception {
                try {
                    e.onNext(loginRequest(name, pwd));
                } catch (Exception e1) {
                    e1.printStackTrace();
                    e.onError(new Throwable(e1.getMessage()));
                } finally {
                    e.onComplete();
                }
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.computation());
    }

    public LoginUser loginRequest(String name, String pwd) {
        Map<String, Object> params = HttpUtil.INSTANCE.getParams();
        params.put("username", name);
        params.put("password", pwd);
        return HttpUtil.INSTANCE.post(HttpConstant.LOGIN_URL, params, LoginUser.class);
    }
}
