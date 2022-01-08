package main.com.studia.devices;

import java.sql.SQLOutput;

public class Diesel extends Car{

    public Diesel(String model, String producer, Integer yearOfProduction) {
        super(model, producer, yearOfProduction);
        this.typeOfEngine = "DIESEL";
    }

    @Override
    public void refuel() {
        System.out.println("Tankowanie samochodu diesel");
    }
}
