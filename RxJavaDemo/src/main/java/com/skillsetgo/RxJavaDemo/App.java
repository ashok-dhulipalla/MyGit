package com.skillsetgo.RxJavaDemo;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        Observable<Integer> observable= Observable.just(12, 10, 18);
        System.out.println( "declared Observable" );
        
        Observer observer= new Observer<Integer>() {

			public void onSubscribe(Disposable d) {
				// TODO Auto-generated method stub
				System.out.println("subscribed");
				
			}

			public void onError(Throwable e) {
				// TODO Auto-generated method stub
				System.out.println("error");
				
			}

			public void onComplete() {
				// TODO Auto-generated method stub
				System.out.println("complete");
				
			}

			public void onNext(Integer t) {
				// TODO Auto-generated method stub
				System.out.println("next: "+t);
				
			}
		};
		System.out.println( "declared Observer" );
        observable.subscribe(observer);
        
        observable= Observable.create(new ObservableOnSubscribe<Integer>() {

			public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
				// TODO Auto-generated method stub
				emitter.onNext(12);
				emitter.onNext(12);
				emitter.onNext(12);
				emitter.onNext(12);
			}
		});
        
        observable.subscribe(observer);
        
        Integer[] arr= new Integer[]{12,10,23,56};
        
        observable= Observable.fromArray(arr).repeat();
        observable.subscribe(observer);
        
        
        
    }
    
    
}
