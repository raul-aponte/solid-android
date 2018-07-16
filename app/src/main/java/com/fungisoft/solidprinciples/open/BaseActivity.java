package com.fungisoft.solidprinciples.open;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.fungisoft.solidprinciples.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
    }

    protected Fragment getCurrentFragment() {
        return getSupportFragmentManager().findFragmentById(R.id.main_content);
    }

    protected GoodPetView getCurrentView() {
        if (getCurrentFragment() instanceof GoodPetView) {
            return (GoodPetView) getCurrentFragment();
        }
        return null;
    }
}
