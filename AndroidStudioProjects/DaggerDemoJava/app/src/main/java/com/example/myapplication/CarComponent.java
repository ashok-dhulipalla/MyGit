package com.example.myapplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {WheelsModule.class, DieselEngineModule.class})
public interface CarComponent {
    public Car getCar();
    public void inject(MainActivity mainActivity);

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder horsePower(@Named("horsePower") int horsePower);

        @BindsInstance
        Builder engineCapacity(@Named("engineCapacity") int engineCapacity);

        CarComponent build();
    }
}
