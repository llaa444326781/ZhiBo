package com.hoarse.zhibo.view.activity;

import android.Manifest;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.hoarse.library.base.BaseActivity;
import com.hoarse.library.utils.permisstion_utils.PermissionListener;
import com.hoarse.zhibo.R;

import java.util.List;

public class SplashActivity extends BaseActivity {
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            requestRuntimePermission(new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE}, new PermissionListener() {
                @Override
                public void onGranted() {
                    startActivity(new MainActivity().getClass());
                    finish();
                }

                @Override
                public void onDenied(List<String> deniedPermission) {
                    for (String permission : deniedPermission) {
                        Toast.makeText(SplashActivity.this, "被拒绝权限：" + permission, Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    };
    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initUI() {
        //StatusBarUtil.setTransparent(this);
        handler.sendEmptyMessageDelayed(1,3000);
    }
    @Override
    public void getData() {

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(1);
    }
}
