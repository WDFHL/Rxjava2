package com.rxjava2.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rxjava2.practice.activity.OperatorsActivity;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //创建:Rx可以方便的创建事件流和数据流
    //组合:Rx使用查询式的操作符组合和变换数据流
    //监听:Rx可以订阅任何可观察的数据流并执行操作

    //观察者:Observer
    //被观察者:Observable
    //Observable和Observer通过subscribe()方法实现订阅关系
    //可以使Observable在需要的时候发出事件来通知Observer

    public void simple(){

        //创建观察者对象 决定事件触发的时候将有怎样的行为
             final Observer<String> observer = new Observer<String>(){

            @Override
            public void onSubscribe(Disposable d) {
                //观察者被订阅时的回调,一般进行一些预处理
                //最开始被调用的地方,截断发送事件只用调用d.dispose()观察者就不会接收到事件了
            }

            @Override
            public void onNext(String s) {
            //处理观察到的事件
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
        //创建被观察者 Observable 决定什么时候触发事件以及触发怎样的事件
        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                observer.onNext("动感光波");
                observer.onNext("嘤嘤嘤");
            }
        });

        //observable订阅observer
        observable.subscribe(observer);

    }




    public void startOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, OperatorsActivity.class));
    }
}
