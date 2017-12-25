package com.example.androidresource.ui.asset;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.androidresource.R;

/**
 * Created by admin on 2017/12/25.
 */

public class AssetWebViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_webview);
        initData();
    }

    private void initData() {
        ((WebView)findViewById(R.id.asset_webView)).loadUrl("file:///android_asset/a.html");
    }
}
