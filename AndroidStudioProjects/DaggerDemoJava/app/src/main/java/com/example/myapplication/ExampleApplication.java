package com.example.myapplication;

import android.app.Application;

public class ExampleApplication extends Application {
    CarComponent carComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        carComponent= DaggerCarComponent.builder()
                .horsePower(120)
                .engineCapacity(1000)
                .build();
    }

    public CarComponent getCarComponent(){
        return carComponent;
    }
}
