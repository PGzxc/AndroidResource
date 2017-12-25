package com.example.androidresource.ui.raw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import com.example.androidresource.R;
import java.io.InputStream;

/**
 * Created by admin on 2017/12/25.
 */

public class RawPicActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raw_pic);
        intiView();
        initData();
    }

    private void intiView() {
        imageView = findViewById(R.id.image_raw_pic);
    }

    private void initData() {
        InputStream inputStream = getResources().openRawResource(R.raw.xiaoxin);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        imageView.setImageBitmap(bitmap);
    }
}
