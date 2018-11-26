package com.zhongbao.zhongbao.utils;

import android.widget.ImageView;

import com.zhongbao.zhongbao.ZBApp;
import com.zhongbao.zhongbao.bean.GlideApp;

public class GlideUtils {
//    public static void displayImage(ImageView imageView, String url, int defImg) {
//        GlideApp.with(NanTangApp.get()).load(resolveUrl(url)).placeholder(defImg).centerCrop().into(imageView);
//    }
//
//    public static void displayImageResize(ImageView imageView, String url) {
//        GlideApp.with(NanTangApp.get()).load(resolveUrl(url)).override(imageView.getMeasuredWidth()).into(imageView);
//    }
//
//    public static void displayImageResize(ImageView imageView, String url, int size) {
//        GlideApp.with(NanTangApp.get()).load(resolveUrl(url)).override(size).into(imageView);
//    }
    public static void loadImage(ImageView imageView, String url) {
        GlideApp.with(ZBApp.get()).load(resolveUrl(url)).into(imageView);
    }
    public static String resolveUrl(String url) {
        if (url == null)
            return "";
        if (url.startsWith("http:")) {
            return url;
        } else {
            return "http://39.98.62.92" + (url.startsWith("/") ? url : "/" + url);
        }
    }
}
