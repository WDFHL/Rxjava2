package com.rxjava2.practice.activity.creating;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.rxjava2.practice.R;
import com.rxjava2.practice.utils.AppConstant;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
        public void onSubscribe(Disposable d) {
            //观察者被订阅时的回调,一般进行一些预处理
            //最开始被调用的地方,截断发送事件只用调用d.dispose()观察者就不会接收到事件了
        }

        @Override
        public void onNext(String s) {
            //处理观察到的事件
            textView.append(" onNext : value : "+  s );
            textView.append(AppConstant.LINE_SEPARATOR);
        }

        @Override
        public void onError(Throwable e) {
            //事件队列异常
        }

        @Override
        public void onComplete() {
            //事件队列完结
        }
    };

    private void doSomeWork() {
        //创建被观察者 Observable 决定什么时候触发事件以及触发怎样的事件
        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                observer.onNext("上面的");
                observer.onNext("下面的");
            }
        });

        //observable订阅observer
        observable.subscribe(observer);

    }
}
