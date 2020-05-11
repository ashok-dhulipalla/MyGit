package com.example.myapplication;

import android.util.Log;

import dagger.Module;
import dagger.Provides;

@Module
public class WheelsModule {

    private static final String TAG = "WheelsModule";
    @Provides
    Rims providesRims(){
        Log.d(TAG, "providesRims: ");
        return new Rims();
    }
    @Provides
    Tires providesTires(){
        Log.d(TAG, "providesTires: ");
        return new Tires();
    }

    @Provides
    Wheels providesWheels(Rims rims, Tires tires){
        Log.d(TAG, "providesWheels: ");
        return new Wheels(rims,tires);
    }
}
