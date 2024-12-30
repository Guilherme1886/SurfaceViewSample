package com.gui.toledo.surfaceview;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SurfaceViewSample surfaceViewSample = new SurfaceViewSample(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(surfaceViewSample);
    }
}
