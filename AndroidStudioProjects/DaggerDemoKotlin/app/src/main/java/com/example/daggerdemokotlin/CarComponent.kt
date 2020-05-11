package com.example.daggerdemokotlin

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [PetrolEngineModule::class, WheelsModule::class])
interface CarComponent {
    fun getCar(): Car

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun powerCapacity(@Named("power")powerCapacity:Int) :Builder

        @BindsInstance
        fun engineCapacity(@Named("engine")engineCapacity:Int) :Builder

        fun build(): CarComponent
    }
}