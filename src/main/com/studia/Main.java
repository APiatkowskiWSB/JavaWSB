package main.com.studia;


import main.com.studia.creatures.*;
import main.com.studia.devices.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
        Car dieselCar = new Diesel("A4", "Audi", 2018, human, 0.0);
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
        Car electric = new Electric("Micra", "Nissan", 2015, human, 1000.0);
        electric.refuel();
        electric.value = 2000.0;

        Human carsOwner = new Human("Kazik", 5);
        Car passat = new LPG("Vw","Passat", 1998, carsOwner, 1000.0);
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
        System.out.println();
        System.out.println("Testowanie zadania 12");
        System.out.println();
        Car audiA4 = new Diesel("A4", "Audi", 2021, seller, 2000.0);
        audiA4.sell(human, buyer, 1000.0);
        audiA4.sell(seller, buyer, 1000.0);
        audiA4.sell(buyer, human, 500.0);
        audiA4.doesASoldCarToB(seller, buyer);
        audiA4.doesASoldCarToB(buyer, seller);
        audiA4.wasAnOwner(seller);
        System.out.println("Z udzialem audiA4 było " + audiA4.getNumberOfTransactionForCar(audiA4) + "transakcji");
        System.out.println("Transakcje dla tego samochodu to :");
        for (CarTransaction carTransaction: audiA4.transactions) {
            System.out.println(carTransaction.toString());
        }

        System.out.println();
        System.out.println("Testowanie zadania 13");
        System.out.println();
        Application runApp = new Application("RunApp", 0, "1.5.0");
        Application youtube = new Application("Youtube", 300, "1.5.0");
        Application strava = new Application("Strava", 1000, "1.5.0");
        Application twitter = new Application("Twitter", 300, "1.5.0");
        Application facebook = new Application("Facebook", 200, "1.5.0");
        buyer.setPhone(iphone);
        iphone.installAnAppOnPhone(runApp);
        iphone.installAnAppOnPhone(youtube);
        iphone.installAnAppOnPhone(twitter);
        iphone.installAnAppOnPhone(facebook);
        iphone.installAnAppOnPhone(strava);

        iphone.isApplicationInstalledOnPhone(runApp);
        iphone.isApplicationInstalledOnPhone(facebook);
        iphone.isApplicationInstalledOnPhone("RunApp");
        iphone.isApplicationInstalledOnPhone("Niezainstalowana aplikacja");

        iphone.getAllFreeApplicationOnPhone();
        iphone.getAllApplicationNamesInAlphabeticOrder();
        iphone.getApplicationsValue();
        iphone.getAllAppInOrderFromCheapeastToExpensive();

    }
}
