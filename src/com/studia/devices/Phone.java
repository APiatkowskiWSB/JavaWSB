package com.studia.devices;

public class Phone extends Device {
    final Double screenSize;
    String os;

    public Phone(String producer, String model, Double screenSize, Integer yearOfProduction) {
        super(yearOfProduction);
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
    }
}
