package com.sf.tinker.ui.login;

import com.sf.tinker.business.LoginBiz;
import com.sf.tinker.business.LoginBizImpl;
import com.sf.tinker.entity.LoginUser;
import com.sf.tinker.ui.base.BasePresenter;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by 01243141 on 2017/12/14.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    LoginBiz loginBiz = new LoginBizImpl();

    public void login(String name, String pwd) {
        if (!checkUserName(name)) {
            getView().toastUserNameInvalid();
            return;
        }
        getView().showLoading();
        loginBiz.login(name, pwd).subscribe(new Observer<LoginUser>() {
            @Override
            public void onSubscribe(Disposable d) {
                // nothing
                getView().addDispose(d);
            }

            @Override
            public void onNext(LoginUser loginUser) {
                getView().hideLoading();
                getView().toMainActivity();
            }

            @Override
            public void onError(Throwable e) {
                getView().hideLoading();
                getView().toMainActivity();
            }

            @Override
            public void onComplete() {
                // nothing

            }
        });

    }

    private boolean checkUserName(String name) {
        if ("".equals(name)) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        new LoginPresenter().login("", "");
    }
}
