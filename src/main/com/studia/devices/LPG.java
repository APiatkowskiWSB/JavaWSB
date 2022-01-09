package main.com.studia.devices;

import main.com.studia.creatures.Human;

public class LPG extends Car {


    public LPG(String model, String producer, Integer yearOfProduction, Human firstOwner) {
        super(model, producer, yearOfProduction, firstOwner);
        this.typeOfEngine = "LPG";
    }

    @Override
    public void refuel() {
        System.out.println("Tankowanie samochodu LPG");
    }
}


