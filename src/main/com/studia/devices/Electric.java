package main.com.studia.devices;

public class Electric extends Car{

    static final String ELECTRIC = "ELECTRIC";
    public Electric(String model, String producer, Integer yearOfProduction) {
        super(model, producer, yearOfProduction);
    }

    @Override
    public void refuel() {
        System.out.println("Ladowanie samochodu");
    }
}
