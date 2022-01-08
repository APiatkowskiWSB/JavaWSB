package main.com.studia;


import main.com.studia.creatures.Animal;
import main.com.studia.creatures.FarmAnimal;
import main.com.studia.creatures.Human;
import main.com.studia.creatures.Pet;
import main.com.studia.devices.Car;
import main.com.studia.devices.Diesel;
import main.com.studia.devices.Phone;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws MalformedURLException {

        Animal dog = new Pet("dog");
        dog.feed();
        dog.takeForAWalk();
        dog.feed(0.5);
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.takeForAWalk();
        dog.feed();

        Human human = new Human("Jan Kowalski");
        Car dieselCar = new Diesel("A4", "Audi", 2018);
        human.car = dieselCar;

        Phone phone = new Phone("Iphone", "12",6.1,2021);
        URL url = new URL("HTTP","appstore.com",8080,"/runApp");
        phone.installAnApp(url);
        phone.installAnApp("RunApp");
        phone.installAnApp("RunApp","12.3");
        phone.installAnApp("RunApp","11.1.23","runApp.com");
    }
}
