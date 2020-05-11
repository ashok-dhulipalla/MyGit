package com.example.myapplication;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class PetrolEngineModule {

    @Binds
    abstract public Engine providesEngine(PetrolEngine petrolEngine);
}
