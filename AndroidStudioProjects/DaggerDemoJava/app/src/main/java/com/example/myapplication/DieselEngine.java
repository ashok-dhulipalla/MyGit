package com.example.myapplication;

import android.util.Log;

import javax.inject.Inject;
import javax.inject.Named;

public class DieselEngine implements Engine{

    private int horsePower;
    private int engineCapacity;
    @Inject
    public DieselEngine(@Named("horsePower") int horsePower, @Named("engineCapacity") int engineCapacity){
        this.horsePower= horsePower;
        this.engineCapacity= engineCapacity;
    }

    private static final String TAG = "DieselEngine";
    @Override
    public void start() {
        Log.d(TAG, "start: Diesel engine started. horsePower: "+horsePower+" EngineCapacity: "+engineCapacity);
    }
}
