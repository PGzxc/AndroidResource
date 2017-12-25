package com.example.androidresource.ui.asset;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.androidresource.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2017/12/25.
 */

public class AssetImgActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asset_img);
        initData();
    }

    private void initData() {

        try {
            AssetManager assets = getAssets();
            InputStream inputStream = assets.open("hzw.jpg");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            ((ImageView)findViewById(R.id.asset_img)).setImageBitmap(bitmap);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
