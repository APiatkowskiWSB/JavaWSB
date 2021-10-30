package com.studia.devices;

public class Phone extends Device {
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
}
