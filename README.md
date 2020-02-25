## Android-LazyLoad-Simple 文档
> 因为推出了Android X,我觉得有必要写个小Demo总结下Android懒加载.
#### AndroidX-LazyLoad
这个Demo是用的AndroidX中的Fragment和ViewPager进行懒加载的描述.
- 创建Adapter的时候设置一个 `BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT`参数
- 在Fragment中的 `onResume`里判断是否是第一次加载
这种与AndroidX之前的懒加载相比, 少了很多的代码,有兴趣想了解为什么可以看看我写的博客.[链接](https://blog.csdn.net/MoLiao2046/article/details/103899277)
#### EarlyLazyLoad
这个Demo是Android X以前我们通常用来处理懒加载的方法,
- 判断Fragment是否显示
- 判断Fragment是否创建
- 判断Fragment是否是第一次加载
#### ViewPager2-LazyLoad
这个Demo是用Android X中的ViewPager2和Fragment来实现懒加载的
- 这种实现懒加载就更容易了, 只需要在Fragment中的 `onResume`里判断是否是第一次加载就行了


  
  

