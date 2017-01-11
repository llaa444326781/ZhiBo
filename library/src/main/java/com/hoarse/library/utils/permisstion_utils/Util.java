package com.hoarse.library.utils.permisstion_utils;

import com.hoarse.library.base.BaseActivity;

import java.util.List;

/**
 * Created by Administrator on 2016/12/27.
 */

public class Util {


    public void test() {
        BaseActivity.requestRuntimePermission(new String[]{}, new PermissionListener() {
            @Override
            public void onGranted() {

            }

            @Override
            public void onDenied(List<String> deniedPermission) {

            }
        });
    }

}
