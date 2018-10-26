package com.zhongbao.zhongbao.bean;

import java.util.HashMap;

/**
 * Used for
 * Created by tuyz on 2018/10/9.
 */

public class ListViewItem {

    //用于区分listview显示的不同item,告诉适配器我这是什么类型，listview适配器根据type决定怎么显示
     public int type;
     //将要显示的数据用HashMap包装好
     public HashMap<String,Object> map ;

     public ListViewItem(int type, HashMap<String, Object> map)
     {
              this.type = type;
              this.map = map;
     }
}
