package com.eric.core;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eric.customization.FeatureConfig;


public class DashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        setupUI();
    }

    private void setupUI() {

        // Customization: A static final boolean to be customized
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

        // Customization: A boolean config in xml to be customized
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
            // Customization: start an activity by intent action
            Intent intent = new Intent();
            intent.setAction(getString(R.string.intent_action_manage));
            startActivity(intent);
        }
    }

    public void onGalleryClicked(View view) {
        if (FeatureConfig.FEATURE_GALLERY) {
            // Customization: start an activity by reflection with customized string of class name
            Intent intent = null;
            try {
                intent = new Intent(this, Class.forName(getString(R.string.class_name_activity_gallery)));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if (intent != null) {
                startActivity(intent);
            }
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
