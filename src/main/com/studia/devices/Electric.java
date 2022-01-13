package main.com.studia.devices;

import main.com.studia.creatures.Human;

public class Electric extends Car {

    static final String ELECTRIC = "ELECTRIC";

    public Electric(String model, String producer, Integer yearOfProduction, Human firstOwner, Double firstSaleValue) {
        super(model, producer, yearOfProduction, firstOwner, firstSaleValue);
        this.typeOfEngine = "ELECTRIC";
    }

    @Override
    public void refuel() {
        System.out.println("Ladowanie samochodu");
    }
}
