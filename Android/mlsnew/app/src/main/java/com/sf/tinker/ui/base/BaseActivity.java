package com.sf.tinker.ui.base;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.sf.tinker.utils.ActivityUtil;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by 01243141 on 2017/12/14.
 */

public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity implements BaseView {
    protected P mPresenter;
    private CompositeDisposable disposable = new CompositeDisposable();
    private ProgressDialog mPDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.injectView(this);
        }
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        injectContentView();
        initViewData();
        initListener();
    }

    protected abstract void injectContentView();

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        initViewData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initViewData();

    protected abstract P createPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }

        if (disposable != null) {
            disposable.clear();
        }
    }

    @Override
    public void showLoading() {
        mPDialog = ProgressDialog.show(this, "", "loading...", true, true);
    }

    @Override
    public void hideLoading() {
        if (mPDialog != null) {
            mPDialog.dismiss();
            mPDialog = null;
        }
    }

    @Override
    public void addDispose(Disposable d) {
        disposable.add(d);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityUtil.setScreenOrientationPortrait(this);
    }
}
