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
 *
 */

public class JustActivity extends AppCompatActivity {
    private static final String TAG = JustActivity.class.getSimpleName();
    Button btn;
    TextView textView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just); btn = findViewById(R.id.btn);
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
            textView.append(" onNext : value : "+  s );
            textView.append(AppConstant.LINE_SEPARATOR);
        }

    };

    private void doSomeWork() {
        //Just 创建一个发射指定值的Observable
       //Just将单个数据转换为发射那个数据的Observable
        Observable observable = Observable.just("上面的","下面的");
        //observable订阅observer
        observable.subscribe(observer);

        //注意：如果你传递null给Just，它会返回一个发射null值得Observable,他不会返回一个空Observable
        //完全不发射任何数据的Observable



    }
}
