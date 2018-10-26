package com.zhongbao.zhongbao.utils;

import android.text.TextUtils;
import com.google.gson.*;
import java.util.ArrayList;
import java.util.List;

public class JsonParseUtils {

  private static final String TAG = "JsonParse";

  private static Gson gson;


  static {
    gson = new GsonBuilder().create();
  }


  public static <T> List<T> jsonToClassList(String json, Class<T> cls) {
    if (!TextUtils.isEmpty(json)) {
      try {
        JsonArray array = new JsonParser().parse(json).getAsJsonArray();
        if (null != array && array.size() > 0) {
          List<T> list = new ArrayList<>();
          for (final JsonElement elem : array) {
            list.add(gson.fromJson(elem, cls));
          }
          return list;
        }
      } catch (IllegalStateException e) {
        e.printStackTrace();
      }
    }
    return null;
  }

}
