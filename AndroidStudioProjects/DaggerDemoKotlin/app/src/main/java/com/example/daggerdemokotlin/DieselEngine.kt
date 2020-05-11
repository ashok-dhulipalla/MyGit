package com.example.daggerdemokotlin

import javax.inject.Inject

class DieselEngine : Engine {

    @Inject
    constructor(){

    }
    override fun start() {
        System.out.println("Diesel engine started")
    }
}