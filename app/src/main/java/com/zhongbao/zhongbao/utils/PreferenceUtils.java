package com.zhongbao.zhongbao.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class PreferenceUtils {
    /**
     * 写入数据(int类型)
     *
     * @param context
     * @param finleName
     * @param k
     * @param v
     */
    public static void write(Context context, String finleName, String k, int v) {
        SharedPreferences preferences = context.getSharedPreferences(finleName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(k, v);
        editor.commit();
    }


    /**
     * 写入数据（boolean数据类型）
     *
     * @param context
     * @param finleName
     * @param k
     * @param v
     */
    public static void write(Context context, String finleName, String k, boolean v) {
        SharedPreferences preferences = context.getSharedPreferences(finleName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(k, v);
        editor.commit();
    }


    /**
     * 写入数据(String数据类型)
     *
     * @param context
     * @param finleName
     * @param k
     * @param v
     */
    public static void write(Context context, String finleName, String k, String v) {
        SharedPreferences preferences = context.getSharedPreferences(finleName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(k, v);
        editor.commit();
    }


    /**
     * 阅读Int数据
     *
     * @param context
     * @param fileName
     * @param k
     * @param defV
     * @return
     */
    public static int readInt(Context context, String fileName, String k, int defV) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preferences.getInt(k, defV);
    }


    /**
     * 阅读Int数据(默认为0)
     *
     * @param context
     * @param fileName
     * @param k
     * @return
     */
    public static int readInt(Context context, String fileName, String k) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preferences.getInt(k, 0);
    }


    /**
     * 阅读String数据
     *
     * @param context
     * @param fileName
     * @param k
     * @param defV
     * @return
     */
    public static String readString(Context context, String fileName, String k, String defV) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preferences.getString(k, defV);
    }

    /**
     * 阅读String数据(默认为null)
     *
     * @param context
     * @param fileName
     * @param k
     * @return
     */
    public static String readString(Context context, String fileName, String k) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preferences.getString(k, null);
    }


    /**
     * 阅读Boolean数据
     *
     * @param context
     * @param fileName
     * @param k
     * @param defV
     * @return
     */
    public static boolean readBoolean(Context context, String fileName, String k, boolean defV) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preferences.getBoolean(k, defV);
    }


    /**
     * 阅读Boolean数据(默认为false)
     *
     * @param context
     * @param fileName
     * @param k
     * @return
     */
    public static boolean readBoolean(Context context, String fileName, String k) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        return preferences.getBoolean(k, false);
    }

    /**
     * 存储List集合
     * @param context 上下文
     * @param key 存储的键
     * @param list 存储的集合
     */
    public static void putList(Context context, String key, List<? extends Serializable> list) {
        try {
            put(context, key, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取List集合
     * @param context 上下文
     * @param key 键
     * @param <E> 指定泛型
     * @return List集合
     */
    public static <E extends Serializable> List<E> getList(Context context, String key) {
        try {
            return (List<E>) get(context, key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 删除文件
     *
     * @param context
     * @param fileName
     * @param k
     */
    public static void remove(Context context, String fileName, String k) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(k);
        editor.commit();
    }


    /**
     * 清除sharedPreferences
     *
     * @param context
     * @param fileName
     */
    public static void clear(Context context, String fileName) {
        SharedPreferences preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
    /**存储对象*/
    private static void put(Context context, String key, Object obj)
            throws IOException
    {
        if (obj == null) {//判断对象是否为空
            return;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos  = null;
        oos = new ObjectOutputStream(baos);
        oos.writeObject(obj);
        // 将对象放到OutputStream中
        // 将对象转换成byte数组，并将其进行base64编码
        String objectStr = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
        baos.close();
        oos.close();

        putString(context, key, objectStr);
    }

    /**
     * 存入字符串
     *
     * @param context 上下文
     * @param key     字符串的键
     * @param value   字符串的值
     */
    public static void putString(Context context, String key, String value) {
        SharedPreferences preferences = getSp(context);
        //存入数据
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
    /**获取对象*/
    private static Object get(Context context, String key)
            throws IOException, ClassNotFoundException
    {
        String wordBase64 = getString(context, key);
        // 将base64格式字符串还原成byte数组
        if (TextUtils.isEmpty(wordBase64)) { //不可少，否则在下面会报java.io.StreamCorruptedException
            return null;
        }
        byte[]               objBytes = Base64.decode(wordBase64.getBytes(), Base64.DEFAULT);
        ByteArrayInputStream bais     = new ByteArrayInputStream(objBytes);
        ObjectInputStream ois      = new ObjectInputStream(bais);
        // 将byte数组转换成product对象
        Object obj = ois.readObject();
        bais.close();
        ois.close();
        return obj;
    }
    /**
     * 获取字符串
     *
     * @param context 上下文
     * @param key     字符串的键
     * @return 得到的字符串
     */
    public static String getString(Context context, String key) {
        SharedPreferences preferences = getSp(context);
        return preferences.getString(key, "");
    }

    /**
     * 获取字符串
     *
     * @param context 上下文
     * @param key     字符串的键
     * @param value   字符串的默认值
     * @return 得到的字符串
     */
    public static String getString(Context context, String key, String value) {
        SharedPreferences preferences = getSp(context);
        return preferences.getString(key, value);
    }
    private static SharedPreferences sp;
    private static SharedPreferences getSp(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("SpUtil", Context.MODE_PRIVATE);
        }
        return sp;
    }
}