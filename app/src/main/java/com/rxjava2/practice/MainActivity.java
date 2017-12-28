package com.rxjava2.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rxjava2.practice.activity.OperatorsActivity;

import rx.Observable;
import rx.Observer;


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
                 public void onCompleted() {
                     //事件队列完结
                     //正常终止,如果没有遇到错误,Observable在最后一次调用onNext之后调用此方法
                 }

                 @Override
                 public void onError(Throwable e) {
                     //事件队列异常
                     //当Observable遇到错误或者无法返回期望的数据时会调用这个方法,这个调用会终止Observable
                     //后续不会再调用onNext和onCompleted，onError方法的参数是抛出的异常.
                 }

                 @Override
                 public void onNext(String s) {
                     //处理观察到的事件
                     //Observable调用这个方法发射数据,方法的参数就是Observable发射的数据,这个方法可能会被调用多次,取决于你的实现
                     //传递数据给onNext通常称作发射,onCompleted和onError被称作通知
                 }
             };
        //创建被观察者 Observable 决定什么时候触发事件以及触发怎样的事件
        Observable observable = Observable.create(new Observable.OnSubscribe() {
            @Override
            public void call(Object o) {
                observer.onNext("动感光波");
                observer.onNext("嘤嘤嘤");
            }
        });

        //一个观察者(Observer)订阅一个可观察对象(Observable)
        observable.subscribe(observer);

    }




    public void startOperatorsActivity(View view) {
        startActivity(new Intent(MainActivity.this, OperatorsActivity.class));
    }
}
