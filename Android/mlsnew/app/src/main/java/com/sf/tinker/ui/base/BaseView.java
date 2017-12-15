package com.sf.tinker.ui.base;

import io.reactivex.disposables.Disposable;

/**
 * Created by 01243141 on 2017/12/14.
 */

public interface BaseView {
    void showLoading();

    void hideLoading();


    void addDispose(Disposable d);
}
