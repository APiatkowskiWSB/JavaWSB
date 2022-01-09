package main.com.studia;


import main.com.studia.creatures.Animal;
import main.com.studia.creatures.FarmAnimal;
import main.com.studia.creatures.Human;
import main.com.studia.creatures.Pet;
import main.com.studia.devices.Car;
import main.com.studia.devices.Diesel;
import main.com.studia.devices.Electric;
import main.com.studia.devices.Phone;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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

        System.out.println();

        Human human = new Human("Jan Kowalski");
        Car dieselCar = new Diesel("A4", "Audi", 2018);
        dieselCar.value = 2000.0;
        human.checkIfHumanCanBuyCar(dieselCar);
        human.setSalary(5000.0);
        System.out.println();
        human.checkIfHumanCanBuyCar(dieselCar);

        human.setSalary(2000.0);
        System.out.println();
        human.getSalary();
        System.out.println();
        human.setSalary(3500.0);
        System.out.println();
        human.getSalary();

        System.out.println();

        Phone iphone = new Phone("Iphone", "12",6.1,2021);
        iphone.toString();
        System.out.println();
        iphone.turnOn();
        dieselCar.turnOn();
        URL url = new URL(Phone.DEFAULT_PROTOCOL,Phone.DEFAULT_SERVER_ADDRESS,8080,"/" + Phone.DEFAULT_APPLICATION + "v" + Phone.DEFAULT_VERSION);
        iphone.installAnApp(url);
        iphone.installAnApp("RunApp");
        iphone.installAnApp("RunApp","12.3");
        iphone.installAnApp("RunApp","11.1.23","runApp.com");

        List<String> applications = new ArrayList<>();
        applications.add("Facebook");
        applications.add("Twitter");
        applications.add("Instagram");
        iphone.installAnApp(applications);

        Human buyer = new Human("buyer");
        Human seller = new Human("seller");
        human.sell(seller, buyer, 2000.0);
        dieselCar.sell(human,seller,0.0);
        dog.sell(human,buyer,1000.0);

        Animal cat = new Pet("cat");
        cat.feed();
        FarmAnimal chicken = new FarmAnimal("chicken");
        chicken.feed();
        chicken.beEaten();

        dieselCar.refuel();
        Car electric = new Electric("Micra", "Nissan", 2015);
        electric.refuel();
    }
}
