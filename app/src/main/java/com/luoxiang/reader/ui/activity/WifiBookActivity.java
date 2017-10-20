
package com.luoxiang.reader.ui.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.luoxiang.reader.R;
import com.luoxiang.reader.base.BaseActivity;
import com.luoxiang.reader.component.AppComponent;
import com.luoxiang.reader.component.DaggerMainComponent;
import com.luoxiang.reader.utils.NetworkUtils;
import com.luoxiang.reader.wifitransfer.Defaults;
import com.luoxiang.reader.wifitransfer.ServerRunner;

import butterknife.Bind;
import butterknife.OnClick;

public class WifiBookActivity extends BaseActivity {

    public static void startActivity(Context context) {
        context.startActivity(new Intent(context, WifiBookActivity.class));
    }

    @Bind(R.id.mTvWifiName)
    TextView mTvWifiName;
    @Bind(R.id.mTvWifiIp)
    TextView mTvWifiIp;

    @Bind(R.id.tvRetry)
    TextView tvRetry;

    @Override
    public int getLayoutId() {
        return R.layout.activity_wifi_book;
    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    public void initToolBar() {
        mCommonToolbar.setTitle("WiFi传书");
        mCommonToolbar.setNavigationIcon(R.drawable.ab_back);
    }

    @Override
    public void initDatas() {
        String wifiname = NetworkUtils.getConnectWifiSsid(mContext);
        if (!TextUtils.isEmpty(wifiname)) {
            mTvWifiName.setText(wifiname.replace("\"", ""));
        } else {
            mTvWifiName.setText("Unknow");
        }

        String wifiIp = NetworkUtils.getConnectWifiIp(mContext);
        if (!TextUtils.isEmpty(wifiIp)) {
            tvRetry.setVisibility(View.GONE);
            mTvWifiIp.setText("http://" + NetworkUtils.getConnectWifiIp(mContext) + ":" + Defaults.getPort());
            // 启动wifi传书服务器
            ServerRunner.startServer();
        } else {
            mTvWifiIp.setText("请开启Wifi并重试");
            tvRetry.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void configViews() {

    }

    @OnClick(R.id.tvRetry)
    public void retry() {
        initDatas();
    }

    @Override
    public void onBackPressed() {
        if (ServerRunner.serverIsRunning) {
            new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("确定要关闭？Wifi传书将会中断！")
                    .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            finish();
                        }
                    }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ServerRunner.stopServer();
    }
}
