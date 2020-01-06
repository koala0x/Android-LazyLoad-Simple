package com.yey.demo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.yey.demo.fragment.FirstFragment;
import com.yey.demo.fragment.FourthFragment;
import com.yey.demo.fragment.SecondFragment;
import com.yey.demo.fragment.ThirdFragment;

import java.util.ArrayList;

/**
 * 不想被强制性的使用Androidx, 可以将gradle.properties中的android.enableJetifier值设置为false
 * 依赖库使用AndroidX之前的版本:
 * https://developer.android.google.cn/topic/libraries/support-library/packages
 *
 * 早期使用懒加载的DEMO.
 *
 * 参考文章:
 * https://blog.csdn.net/qq_20521573/article/details/103589074
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mVpLazyLoad;
    private ArrayList<BaseFragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVpLazyLoad = (ViewPager) findViewById(R.id.vp);
        addFragments();
        MyFragmentPageAdapter myFragmentPageAdapter = new MyFragmentPageAdapter(getSupportFragmentManager(), mFragments);
        mVpLazyLoad.setAdapter(myFragmentPageAdapter);
    }

    private void addFragments() {
        mFragments = new ArrayList();
        mFragments.add(new FirstFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new ThirdFragment());
        mFragments.add(new FourthFragment());
    }
}
