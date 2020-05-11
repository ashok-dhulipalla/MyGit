package com.example.myapplication;

import android.util.Log;

import javax.inject.Inject;

public class Car {
    private static final String TAG = "Car";

    private Engine engine;
    private Wheels wheels;
    private Driver driver;

    @Inject
    public Car(Driver driver,Engine engine, Wheels wheels) {
        Log.d(TAG, "Car: Constructor");
        this.driver= driver;
        this.engine = engine;
        this.wheels = wheels;
    }

    @Inject
    public void passCarToRemote(Remote remote){
        Log.d(TAG, "passCarToRemote: ");
        remote.setCar(this);
    }

    public void start(){
        engine.start();
        Log.d(TAG, "DRIVER: "+driver);
        Log.d(TAG, "driving....");
    }
}
