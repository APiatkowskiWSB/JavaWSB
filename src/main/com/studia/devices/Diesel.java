package main.com.studia.devices;

import main.com.studia.creatures.Human;

public class Diesel extends Car {

    public Diesel(String model, String producer, Integer yearOfProduction, Human firstOwner, Double firstSaleValue) {
        super(model, producer, yearOfProduction, firstOwner,firstSaleValue);
        this.typeOfEngine = "DIESEL";
    }

    @Override
    public void refuel() {
        System.out.println("Tankowanie samochodu diesel");
    }
}
