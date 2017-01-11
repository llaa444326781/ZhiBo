package com.hoarse.library.utils;

import android.widget.EditText;

/**
 * 1.类的用途:View控件辅助类
 * 2.author:Liuxiaoyu
 * 3.2016/12/28
 */
public class ViewHandler {

    public static void setText(EditText et, CharSequence msg){
        et.setText(msg);
        setSelection(et);
    }

    public static void setSelection(EditText et){
        et.setSelection(et.getText().length());
        et.requestFocus();
    }

}
