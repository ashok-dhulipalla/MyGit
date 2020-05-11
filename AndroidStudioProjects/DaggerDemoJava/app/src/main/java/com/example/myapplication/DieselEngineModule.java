package com.example.myapplication;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public class DieselEngineModule {

    @Provides
    public Engine providesEngine(DieselEngine dieselEngine){
        return dieselEngine;
    }
}
