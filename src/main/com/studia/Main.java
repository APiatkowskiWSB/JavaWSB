package main.com.studia;


import main.com.studia.creatures.*;
import main.com.studia.devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
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
        Car dieselCar = new Diesel("A4", "Audi", 2018, human);
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
        Car electric = new Electric("Micra", "Nissan", 2015, human);
        electric.refuel();
        electric.value = 2000.0;

        Human carsOwner = new Human("Kazik", 5);
        Car passat = new LPG("Vw","Passat", 1998, carsOwner);
        passat.value = 12000.0;
        carsOwner.addCarToGarage(dieselCar);
        carsOwner.addCarToGarage(electric);
        carsOwner.setCar(passat,4);
        carsOwner.getCarsValue();

        human.cash = 1000.0;
        seller.cash = 2000.0;
        buyer.cash = 3000.0;
        carsOwner.cash = 1500.0;
        List<Human> humansToSort = new LinkedList<>();
        humansToSort.add(human);
        humansToSort.add(seller);
        humansToSort.add(buyer);
        humansToSort.add(carsOwner);
        Collections.sort(humansToSort, new HumanCashComparator());
        for (Human humanToPrint: humansToSort){
            System.out.println(humanToPrint.firstName + " ma pieniedzy " + humanToPrint.cash);
        }

    }
}
