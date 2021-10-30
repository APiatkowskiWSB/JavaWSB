package com.studia.devices;

public class Phone {
    final String producer;
    final String model;
    final Double screenSize;
    String os;

    public Phone(String producer, String model, Double screenSize) {
        this.producer = producer;
        this.model = model;
        this.screenSize = screenSize;
    }
}
