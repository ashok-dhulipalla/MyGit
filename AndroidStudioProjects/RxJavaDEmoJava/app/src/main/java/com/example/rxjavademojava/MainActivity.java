package com.example.rxjavademojava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import io.reactivex.Emitter;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Observable, Observer and subscription

        //Types of Operators
        //Create Observables -- just, create, fromArray, range
        //filter the data emitted by an Observable -- debounce, filter, skip, last
        //creates an Observable by transform the data emitted by another Observable -- buffer, map, flatMap, switchMap, compose

        //SubscribeOn(), ObserveOn()
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                System.out.println("SkillSetGo: thread name in observable: "+Thread.currentThread().getName());
                emitter.onNext(1);
                emitter.onNext(12);
                emitter.onNext(1234);
                emitter.onNext(12345);
                emitter.onComplete();
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                //System.out.println("SkillSetGo: thread name in observer: "+Thread.currentThread().getName());
                System.out.println("SkillSetGo: subscribed");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("SkillSetGo: thread name in observer: "+Thread.currentThread().getName());
                System.out.println("SkillSetGo: "+integer);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                System.out.println("SkillSetGo: completed");
            }
        };

        observable.subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.newThread())
                .subscribe(observer);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
