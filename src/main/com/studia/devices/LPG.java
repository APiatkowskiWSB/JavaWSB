package main.com.studia.devices;

public class LPG extends Car{

    static final String LPG = "LPG";

    public LPG(String model, String producer, Integer yearOfProduction) {
        super(model, producer, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Tankowanie samochodu LPG");
    }
}


