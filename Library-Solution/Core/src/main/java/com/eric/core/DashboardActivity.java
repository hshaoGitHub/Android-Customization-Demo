package com.eric.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eric.flex.FeatureConfig;


public class DashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setupUI();
    }

    private void setupUI() {

        if (!FeatureConfig.FEATURE_CAMERA) {
            findViewById(R.id.btn_camera).setVisibility(View.GONE);
        }

        if (!FeatureConfig.FEATURE_GALLERY) {
            findViewById(R.id.btn_gallery).setVisibility(View.GONE);
        }

        if (!FeatureConfig.FEATURE_MANAGE) {
            findViewById(R.id.btn_manage).setVisibility(View.GONE);
        }

        if (!FeatureConfig.FEATURE_SLIDE_SHOW) {
            findViewById(R.id.btn_slide_show).setVisibility(View.GONE);
        }
    }

    public void onCameraClicked(View view) {
        if (FeatureConfig.FEATURE_CAMERA) {
            startActivity(new Intent(this, CameraActivity.class));
        }
    }

    public void onManageClicked(View view) {
        if (FeatureConfig.FEATURE_MANAGE) {
            startActivity(new Intent(this, ManageActivity.class));
        }
    }

    public void onGalleryClicked(View view) {
        if (FeatureConfig.FEATURE_GALLERY) {
            startActivity(new Intent(this, GalleryActivity.class));
        }
    }

    public void onSlideViewClicked(View view) {
        if (FeatureConfig.FEATURE_SLIDE_SHOW) {
            startActivity(new Intent(this, SlideShowActivity.class));
        }
    }
}
