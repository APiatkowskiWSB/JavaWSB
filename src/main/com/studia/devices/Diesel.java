package main.com.studia.devices;

import java.sql.SQLOutput;

public class Diesel extends Car{

    static final String DIESEL ="DIESEL";
    public Diesel(String model, String producer, Integer yearOfProduction) {
        super(model, producer, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Tankowanie samochodu diesel");
    }
}
