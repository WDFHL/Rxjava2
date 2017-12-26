package com.rxjava2.practice.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.rxjava2.practice.R;
import com.rxjava2.practice.activity.async.AsyncActivity;
import com.rxjava2.practice.activity.blocking.BlockingActivity;
import com.rxjava2.practice.activity.combining.CombiningActivity;
import com.rxjava2.practice.activity.conditional.ConditionalActivity;
import com.rxjava2.practice.activity.connect.ConnectActivity;
import com.rxjava2.practice.activity.convert.ConvertActivity;
import com.rxjava2.practice.activity.creating.CreatingActivity;
import com.rxjava2.practice.activity.errorhandling.ErrorHandlingActivity;
import com.rxjava2.practice.activity.filtering.FilteringActivity;
import com.rxjava2.practice.activity.mathematical.MathematicalActivity;
import com.rxjava2.practice.activity.string.StringActivity;
import com.rxjava2.practice.activity.transforming.TransFormingActivity;
import com.rxjava2.practice.activity.utility.UtilityActivity;

/**
 * Created by j on 2017/12/26.
 */

public class OperatorsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operators);
    }

    public void startCreatingActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, CreatingActivity.class));
    }
    public void startTransFormingActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, TransFormingActivity.class));
    }
    public void startFilteringActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, FilteringActivity.class));
    }
    public void startCombiningActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, CombiningActivity.class));
    }
    public void startErrorHandlingActivity(View view){
        startActivity(new Intent(OperatorsActivity.this,ErrorHandlingActivity.class));
    }


    public void startUtilityActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, UtilityActivity.class));
    }
    public void startConditionalActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, ConditionalActivity.class));
    }
    public void startMathematicalActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, MathematicalActivity.class));
    }
    public void startAsyncActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, AsyncActivity.class));
    }
    public void startConnectActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, ConnectActivity.class));
    }

    public void startConvertActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, ConvertActivity.class));
    }
    public void startBlockingActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, BlockingActivity.class));
    }
    public void startStringActivity(View view){
        startActivity(new Intent(OperatorsActivity.this, StringActivity.class));
    }

}
