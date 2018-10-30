package com.zhongbao.zhongbao.base;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.loader.ImageLoader;
import com.zhongbao.zhongbao.utils.CornerTransform;
import com.zhongbao.zhongbao.utils.Util;

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        //Glide 加载图片简单用法
//        CornerTransform transformation = new CornerTransform(context, Util.dip2px(context,0));
//        transformation.setExceptCorner(true, true, true, true);
        Glide.with(context.getApplicationContext())
                .load(path)
                .asBitmap()
                .skipMemoryCache(true)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .transform(transformation)
                .into(imageView);

//        Glide.with(context.getApplicationContext())
//                .load(path)
//                .into(imageView);
    }
}