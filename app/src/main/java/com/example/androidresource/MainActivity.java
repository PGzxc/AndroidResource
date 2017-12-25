package com.example.androidresource;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androidresource.ui.asset.AssetImgActivity;
import com.example.androidresource.ui.asset.AssetMusicActivity;
import com.example.androidresource.ui.asset.AssetWebViewActivity;
import com.example.androidresource.ui.raw.RawMusicActivity;
import com.example.androidresource.ui.raw.RawPicActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListener();
    }

    private void setListener() {
        findViewById(R.id.btn_raw_music).setOnClickListener(view -> startActivity(RawMusicActivity.class));
        findViewById(R.id.btn_raw_pic).setOnClickListener(view -> startActivity(RawPicActivity.class));
        findViewById(R.id.btn_assets_web).setOnClickListener(view -> startActivity(AssetWebViewActivity.class));
        findViewById(R.id.btn_assets_img).setOnClickListener(view -> startActivity(AssetImgActivity.class));
        findViewById(R.id.btn_assets_music).setOnClickListener(view -> startActivity(AssetMusicActivity.class));
    }

    public void startActivity(Class cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

}
