package main.com.studia.devices;

public class LPG extends Car{



    public LPG(String model, String producer, Integer yearOfProduction) {
        super(model, producer, yearOfProduction);
        this.typeOfEngine = "LPG";
    }

    @Override
    public void refuel() {
        System.out.println("Tankowanie samochodu LPG");
    }
}


