package com.yey.demo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.yey.demo2.fragment.FirstFragment;
import com.yey.demo2.fragment.FourthFragment;
import com.yey.demo2.fragment.SecondFragment;
import com.yey.demo2.fragment.ThirdFragment;

import java.util.ArrayList;

/**
 * AndroidX 中因为Fragment 中setUserVisibleHint失效了, 所以不能用以前的那种方式来做懒加载了
 * Androidx中懒加载的实现更为方便了.
 * Google 现在也出来了新的ViewPager2了, 往后懒加载会越来越少出现在我们的视野中.
 * <p>
 * 参考文章:
 * https://blog.csdn.net/qq_20521573/article/details/103589074
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;
    private ArrayList<Fragment> mFragments;

    /**
     * 查看FragmentStatePagerAdapter 中的setPrimaryItem方法可以得知, 当FragmentStatePagerAdapter中传入的behavior为FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT时候,以前的那种通过setUserVisibleHint方法实现的懒加载依然能够使用
     * 当FragmentStatePagerAdapter中传入的behavior为FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT时候,默认下一个页面Fragment对象会被创建, 但是不会执行onResume回调方法,所以可以在OnResume之中做文章,实现懒加载.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mVp = (ViewPager) findViewById(R.id.vp);
        addFragments();
        MyFragmentStatePagerAdapter myFragmentStatePagerAdapter = new MyFragmentStatePagerAdapter(
                getSupportFragmentManager(),
                //FragmentStatePagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT, 兼容以前那种方式实现的懒加载
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT,
                mFragments);
        mVp.setAdapter(myFragmentStatePagerAdapter);
    }

    private void addFragments() {
        mFragments = new ArrayList();
        mFragments.add(new FirstFragment());
        mFragments.add(new SecondFragment());
        mFragments.add(new ThirdFragment());
        mFragments.add(new FourthFragment());
    }

}
