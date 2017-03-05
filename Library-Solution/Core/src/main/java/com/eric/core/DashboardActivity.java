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

        // Flex: A static final boolean to be customized
        // Invalid code will be removed by compiler
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

        // Flex: A boolean config in xml to be customized
        // Default Android resource overlay, runtime customization
        // Invalid code won't be removed
        if (!getResources().getBoolean(R.bool.feature_share)) {
            findViewById(R.id.btn_share).setVisibility(View.GONE);
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

    public void onShareClicked(View view) {
        if (getResources().getBoolean(R.bool.feature_share)) {
            startActivity(new Intent(this, ShareActivity.class));
        }
    }
}
