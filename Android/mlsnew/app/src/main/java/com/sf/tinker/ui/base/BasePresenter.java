package com.sf.tinker.ui.base;

import java.lang.ref.WeakReference;

/**
 * Created by 01243141 on 2017/12/14.
 */

public class BasePresenter<V extends BaseView> {
    WeakReference<V> viewRef;

    public void onDestroy() {
        if (viewRef != null) {
            viewRef = null;
        }
    }

    void injectView(V baseView) {
        viewRef = new WeakReference<>(baseView);
    }

    protected V getView() {
        if (viewRef != null) {
            return viewRef.get();
        }
        return null;
    }

    protected void showLoading() {
        getView().showLoading();
    }

    protected void hideLoading() {
        getView().hideLoading();
    }
}
