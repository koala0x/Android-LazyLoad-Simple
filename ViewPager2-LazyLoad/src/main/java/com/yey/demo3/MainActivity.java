package com.yey.demo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.yey.demo3.fragment.FirstFragment;
import com.yey.demo3.fragment.FourthFragment;
import com.yey.demo3.fragment.SecondFragment;
import com.yey.demo3.fragment.ThirdFragment;

import java.util.ArrayList;

/**
 * 使用ViewPager2 如何进行懒加载
 * 参考文章:
 * https://developer.android.google.cn/training/animation/screen-slide-2?hl=zh_cn
 * https://juejin.im/post/5df4aabe6fb9a0161104c8eb#heading-11
 * 当设置Limit为1时候, 默认会多创建一个Fragment对象, 但是创建之后不会调用该对象的onResume生命周期,只是会调用onStart生命周期方法,ViewPager2 默认是不会去做缓存的
 */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = FirstFragment.class.getName();
    private ViewPager2 mVp;
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addFragments();
        mVp = (ViewPager2) findViewById(R.id.vp2);
        MyFragmentStateAdapter myFragmentStateAdapter = new MyFragmentStateAdapter(getSupportFragmentManager(), this.getLifecycle(), mFragments);
//        mVp.setPageTransformer(new ZoomOutPageTransformer());
//        mVp.setOrientation(ViewPager2.ORIENTATION_VERTICAL); ViewPager2 垂直滑动
//        mVp.setOffscreenPageLimit(1);//当设置Limit为1时候,将缓存一个页面,(Limit的值必须大于0)
        mVp.setAdapter(myFragmentStateAdapter);
        mVp.setOffscreenPageLimit(2);
    }

    private void addFragments() {
        mFragments = new ArrayList();
        mFragments.add(new FirstFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new ThirdFragment());
        mFragments.add(new FourthFragment());
    }

}
