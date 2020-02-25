package com.yey.demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * AndroidX 之前平时使用的常见的懒加载方式
 */
public abstract class BaseFragment extends Fragment {
    //是否可见
    boolean isShow = false;
    //是否创建View
    boolean isCreate = false;
    //是否是第一次加载
    boolean isFirstLoad = true;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        isShow = isVisibleToUser;
        //尝试加载
        onLazyLoad();

    }

    /**
     * 该方法在onCreateView 方法执行之后调用
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isCreate = true;
        //尝试加载
        onLazyLoad();
    }


    public void onLazyLoad() {
        if (isFirstLoad && isShow && isCreate) {
            isFirstLoad = !isFirstLoad;
            lazyLoad();
        }
    }

    /**
     * 上述三个条件符合即可进行懒加载
     */
    public abstract void lazyLoad();


}
