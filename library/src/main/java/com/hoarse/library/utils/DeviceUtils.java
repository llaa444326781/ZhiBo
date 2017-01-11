package com.hoarse.library.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
/**
 * 1.类的用途:
 * 2.author:Liuxiaoyu
 * 3.2016/12/28
 */
public class DeviceUtils {
    public static  String getDeviceId(Context context) {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        String DEVICE_ID = tm.getDeviceId();
        return DEVICE_ID;
    }

}
