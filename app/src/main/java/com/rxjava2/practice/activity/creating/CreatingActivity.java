package com.rxjava2.practice.activity.creating;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rxjava2.practice.R;

/**
 * Created by j on 2017/12/26.
 */

public class CreatingActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creating);
    }
    public void startCreateActivity(View view){
        startActivity(new Intent(CreatingActivity.this, CreateActivity.class));
    }
    public void startDeferActivity(View view){
        startActivity(new Intent(CreatingActivity.this, DeferActivity.class));
    }
    public void startFromActivity(View view){
        startActivity(new Intent(CreatingActivity.this, FromActivity.class));
    }
    public void startJustActivity(View view){
        startActivity(new Intent(CreatingActivity.this, JustActivity.class));
    }
    public void startStartActivity(View view){
        startActivity(new Intent(CreatingActivity.this, StartActivity.class));
    }
    public void startRepeatActivity(View view){
        startActivity(new Intent(CreatingActivity.this, RepeatActivity.class));
    }
    public void startRangeActivity(View view){
        startActivity(new Intent(CreatingActivity.this, RangeActivity.class));
    }

}
