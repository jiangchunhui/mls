package com.sf.tinker.ui;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sf.tinker.R;
import com.sf.tinker.ui.adapter.MainTabAdapter;
import com.sf.tinker.ui.base.BaseActivity;
import com.sf.tinker.ui.base.BaseFragment;
import com.sf.tinker.ui.base.BasePresenter;
import com.sf.tinker.ui.home.HomeFragment;
import com.sf.tinker.ui.mine.MineFragment;
import com.sf.tinker.ui.notice.NoticeFragment;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private MainTabAdapter mTabAdapter;

    private int[] mStatusColors = new int[]{
            R.color.status_color_red,
            R.color.status_color_grey,
            R.color.status_color_grey,
    };
    private TextView btHome;
    private TextView btNotice;
    private TextView btMine;
    private View lyHome;
    private View lyNotice;
    private View lyMine;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void injectContentView() {
        btHome = (TextView) findViewById(R.id.btHome);
        btNotice = (TextView) findViewById(R.id.btNotice);
        btMine = (TextView) findViewById(R.id.btMine);
        lyHome = findViewById(R.id.lyHome);
        lyNotice = findViewById(R.id.lyNotice);
        lyMine = findViewById(R.id.lyMine);
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initListener() {

    }

    @Override
    public void initViewData() {



        ArrayList<BaseFragment> mFragments = new ArrayList<>(4);
        mFragments.add(new HomeFragment());
        mFragments.add(new NoticeFragment());
        mFragments.add(new MineFragment());
    }


}
