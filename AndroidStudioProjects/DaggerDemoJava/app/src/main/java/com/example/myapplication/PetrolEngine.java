package com.example.myapplication;

import android.util.Log;

import javax.inject.Inject;

public class PetrolEngine implements Engine{

    @Inject
    public PetrolEngine(){

    }
    private static final String TAG = "PetrolEngine";
    @Override
    public void start() {
        Log.d(TAG, "start: Petrol engine started");
    }
}
