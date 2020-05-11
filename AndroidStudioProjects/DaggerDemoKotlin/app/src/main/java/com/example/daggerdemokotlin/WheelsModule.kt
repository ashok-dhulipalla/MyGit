package com.example.daggerdemokotlin

import dagger.Module
import dagger.Provides

@Module
class WheelsModule {

    @Provides
    fun providesRims(): Rims{
        System.out.println("rims created")
        return Rims()
    }

    @Provides
    fun providesTires():Tires{
        System.out.println("tires created")
        return Tires()
    }

    @Provides
    fun providesWheels(rims: Rims,tires: Tires):Wheels{
        System.out.println("Wheels module")
        return Wheels(rims,tires)
    }
}