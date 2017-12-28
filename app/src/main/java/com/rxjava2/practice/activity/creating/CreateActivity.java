package com.rxjava2.practice.activity.creating;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rxjava2.practice.R;
import com.rxjava2.practice.utils.AppConstant;

import rx.Observable;
import rx.Observer;


/**
 * Created by j on 2017/12/26.
 */

public class CreateActivity extends AppCompatActivity {
    private static final String TAG = CreateActivity.class.getSimpleName();
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        btn = findViewById(R.id.btn);
        textView = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doSomeWork();
            }
        });
    }
    //创建观察者对象 决定事件触发的时候将有怎样的行为
    Observer<String> observer = new Observer<String>(){


        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(String s) {

        }
    };

    private void doSomeWork() {
        //创建被观察者 Observable 决定什么时候触发事件以及触发怎样的事件
        Observable observable = Observable.create(new Observable.OnSubscribe() {
            @Override
            public void call(Object o) {

            }
        });


        //observable订阅observer
        observable.subscribe(observer);

    }
}
