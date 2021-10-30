package com.studia.devices;

import com.studia.Saleable;

public class Phone extends Device implements Saleable {
    final Double screenSize;
    String os;

    public Phone(String producer, String model, Double screenSize, Integer yearOfProduction) {
        super(yearOfProduction, producer, model);
        this.screenSize = screenSize;
    }

    @Override
    public void turnOn() {
        System.out.println("Klikam guzik wlaczajacy telefon");
    }

    @Override
    public void sale() {
        
    }

    @Override
    public void getPrice() {

    }
}
