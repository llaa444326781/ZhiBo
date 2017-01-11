package com.hoarse.library.base;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.hoarse.library.utils.permisstion_utils.ActivityCollector;
import com.hoarse.library.utils.permisstion_utils.PermissionListener;
import com.jaeger.library.StatusBarUtil;
import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * 1.类的用途:所有子Activity的基类
 * 2.@ author:Liuxiaoyu
 * 3.@ 2016/12/28.
 */

public abstract class BaseActivity extends AppCompatActivity implements MyInterface{
    /**
     * 是否沉浸状态栏
     **/
    private boolean isSetStatusBar = true;
    private View view;
    private static PermissionListener mListener;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
        if (getLayout() != 0) {
            int layout = getLayout();
            view = View.inflate(this, layout, null);
            supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
            //设置状态栏透明
            StatusBarUtil.setTransparent(this);
            setContentView(view);
            if (isSetStatusBar) {
                steepStatusBar();
            }
            //注入view
            ButterKnife.bind(this);
            initUI();
            getData();
        }
    }

    /**
     *  返回的toolbar
     * @param toolbar
     * @param title
     */
    protected void setToolbar(Toolbar toolbar, String title) {
        toolbar.setTitle(title);
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    /**
     * [页面跳转]
     *
     * @param clz
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(BaseActivity.this, clz));
    }

    /**
     * [携带数据的页面跳转]
     *
     * @param bundle
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }
    /**
     * 绑定控件
     *
     * @param resId
     */
    public <T extends View> T findView(int resId) {
        return (T) findViewById(resId);
    }

    /**
     * 添加fragment
     *
     * @param layoutId 原来的布局
     * @param fragment
     */

    public void addFragment(int layoutId, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.add(layoutId, fragment);
        beginTransaction.commit();
    }
    /**
     * 移除fragment
     *
     * @param fragment
     */
    public void removeFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.remove(fragment);
        beginTransaction.commit();
    }
    /**
     * 替换的 方法
     *
     * @param layoutId
     * @param fragment
     */
    public void replaceFragment(int layoutId, Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction beginTransaction = manager.beginTransaction();
        beginTransaction.replace(layoutId, fragment);
        beginTransaction.commit();
    }
    public FragmentManager getManger() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        return fragmentManager;
    }
    /**
     * 沉浸状态栏
     */
    private void steepStatusBar() {
        //当系统版本为4.4或者4.4以上时可以使用沉浸式状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 透明状态栏
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 透明导航栏
             getWindow().addFlags(
                   WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
    public  static void setStatusColor(Activity activity,int id){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatus(activity, true);
        }
        SystemBarTintManager tintManager = new SystemBarTintManager(activity);
        tintManager.setStatusBarTintEnabled(true);
        // 使用颜色资源
        tintManager.setStatusBarTintResource(id);

    }
    //设置状态栏颜色
    private static void setTranslucentStatus(Activity activity, boolean on) {
        Window win = activity.getWindow();
        WindowManager.LayoutParams winParams = win.getAttributes();
        final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        if (on) {
            winParams.flags |= bits;
        } else {
            winParams.flags &= ~bits;
        }
        win.setAttributes(winParams);
    }
    public static void requestRuntimePermission(String[] permissions, PermissionListener listener) {
        Activity topActivity = ActivityCollector.getTopActivity();
        if (topActivity == null) {
            return;
        }
        mListener = listener;
        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(topActivity, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }
        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(topActivity, permissionList.toArray(new String[permissionList.size()]), 1);
        } else {
            mListener.onGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0) {
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedPermissions.add(permission);
                        }
                    }
                    if (deniedPermissions.isEmpty()) {
                        mListener.onGranted();
                    } else {
                        mListener.onDenied(deniedPermissions);
                    }
                }
                break;
            default:
                break;
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        view = null;
        ActivityCollector.removeActivity(this);
    }
}
