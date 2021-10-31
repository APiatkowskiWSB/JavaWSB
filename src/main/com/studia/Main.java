package main.com.studia;


import main.com.studia.creatures.FarmAnimal;
import main.com.studia.creatures.Human;
import main.com.studia.devices.Car;
import main.com.studia.devices.Phone;

public class Main {

    public static void main(String[] args) {
        Human kazik = new Human("Kazik");
        Human zenek = new Human("Zenek");
        Phone phone = new Phone("Samsung", "S20", 5.5,2020);
        zenek.phone = phone;

        kazik.cash = 2000.0;

        phone.sell(zenek, kazik, 2100.0);

        Car car = new Car("Audi", "S5", 2020);
        zenek.car = car;
        kazik.cash = 5000.0;
        car.sell(zenek,kazik,5000.0);
        kazik.cash = 2000.0;

        zenek.sell(zenek,kazik,5000.0);

        Human siostra = new Human("Justyna");

        FarmAnimal indyk = new FarmAnimal("indyk");
        indyk.setWeight(5.0);
        indyk.feed(1.5);
        indyk.feed();
        indyk.beEaten();
    }
}
