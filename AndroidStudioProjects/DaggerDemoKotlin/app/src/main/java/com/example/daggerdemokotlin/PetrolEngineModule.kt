package com.example.daggerdemokotlin

import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
class PetrolEngineModule {

    @Provides
    fun providesPetrolEngine(petrolEngine: PetrolEngine) : Engine{
        return petrolEngine
    }
}