package main.com.studia.devices;

import main.com.studia.creatures.Human;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Phone extends Device implements Saleable {
    final Double screenSize;
    String os;
    public final static String DEFAULT_SERVER_ADDRESS = "85.128.128.104";
    public final static String DEFAULT_PROTOCOL = "HTTP";
    public final static String DEFAULT_VERSION = "10.2.13";
    public final static String DEFAULT_APPLICATION = "INTELLIJ";
    public Human phoneOwner;
    public List<Application> phoneApplications;

    public Phone(String producer, String model, Double screenSize, Integer yearOfProduction) {
        super(yearOfProduction, producer, model);
        this.screenSize = screenSize;
        phoneApplications = new ArrayList<>();
    }

    @Override
    public void turnOn() {
        System.out.println("Klikam guzik wlaczajacy telefon");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (this.equals(seller.getPhone())) {
            System.out.println("Sprzedajacy posiada ten telefon do sprzedania");
            if (buyer.cash >= price) {
                System.out.println("Kupujacy ma wystarczajaco gotówki");
                buyer.cash -= price;
                seller.cash += price;
                seller.setPhone(null);
                System.out.println(seller.firstName + " sprzedal telefon " + this.producer + " " + this.model + " za cene " + price);
                buyer.setPhone(this);
                System.out.println(buyer.firstName + " kupil telefon " + this.producer + " " + this.model + " za cene " + price);
                System.out.println("Transakcja zakonczona");
            } else {
                System.out.println("Kupujacy nie ma wystarczaco gotówki, transakcja niemożliwa");
            }
        } else {
            System.out.println("Sprzedajacy nie posiada tego telefonu");
        }
    }

    @Override
    public String toString() {
        return "Phone{" +
                "yearOfPRoduction=" + yearOfPRoduction +
                ", producer='" + producer + '\'' +
                ", model='" + model + '\'' +
                ", screenSize=" + screenSize +
                ", os='" + os + '\'' +
                '}';
    }

    public void installAnApp(String nazwaAplikacji) {
        installAnApp(nazwaAplikacji, DEFAULT_VERSION);
    }

    public void installAnApp(String nazwaAplikacji, String wersjaAplikacji) {
        installAnApp(nazwaAplikacji, wersjaAplikacji, DEFAULT_SERVER_ADDRESS);
    }

    public void installAnApp(String nazwaAplikacji, String wersjaAplikacji, String adresServera) {
        System.out.println("zainstalowano na telefonie aplikacje " + nazwaAplikacji + " w wersji " + wersjaAplikacji +
                " z servera " + adresServera);
    }

    public void installAnApp(List<String> applicationsToInstall) {
        for (String application : applicationsToInstall) {
            installAnApp(application);
        }
    }

    public void installAnApp(URL url) {
        System.out.println("twoj url to: " + url);
        System.out.println("Zainstalowana aplikacja to " + DEFAULT_APPLICATION + " w wersji " + DEFAULT_VERSION);
    }

    public void installAnAppOnPhone(Application application) {
        if (this.phoneOwner.cash < application.price) {
            System.out.println("Wlasciciel ma za malo pieniedzy na aplikacje " + application.applicationName);
        } else {
            this.phoneOwner.cash -= application.price;
            System.out.println("Aplikacja zostala zainstalowana :" + application.applicationName);
            phoneApplications.add(application);
        }
    }

    public void isApplicationInstalledOnPhone(Application application) {
        if (phoneApplications.contains(application)){
            System.out.println("Applikacja " + application.applicationName +" jest zainstalowana na telefonie");
        } else {
            System.out.println("Applikacja " + application.applicationName +" nie jest zainstalowana na telefonie");
        }
    }

    public void isApplicationInstalledOnPhone(String appName) {
        if (phoneApplications.stream()
                .filter(application -> application.applicationName.equals(appName))
                .count() > 0){
            System.out.println("Applikacja " + appName +" jest zainstalowana na telefonie");
        } else {
            System.out.println("Applikacja " + appName +" nie jest zainstalowana na telefonie");
        }
    }

    public void getAllFreeApplicationOnPhone() {
        List<Application> freeApplications = phoneApplications.stream()
                .filter(application -> application.price == 0)
                .collect(Collectors.toList());
        if (freeApplications.size() == 0) {
            System.out.println("Na telefonie nie ma darmowych aplikacji");
        } else {
            System.out.println("Darmowe aplikacje to :");
            System.out.println(freeApplications.stream().map(application -> application.applicationName)
                                                        .collect(Collectors.joining(", ")));
        }
    }

    public void getApplicationsValue() {
        double applicationsValue = 0;
        for (Application application: phoneApplications) {
            applicationsValue += application.price;
        }
        System.out.println("Wszystkie aplikacje sa warte " + applicationsValue);
    }

    public void getAllApplicationNamesInAlphabeticOrder() {
        System.out.println("Aplikacje w kolejnosci alfabetycznej to:");
        Collections.sort(phoneApplications, new ApplicationNameComparator());
        for (Application application: phoneApplications) {
            System.out.println(application.applicationName);
        }
    }

    public void getAllAppInOrderFromCheapeastToExpensive() {
        System.out.println("Aplikacje w kolejnosci od najtanszej to:");
        Collections.sort(phoneApplications, new ApplicationValueComparator());
        for (Application application: phoneApplications) {
            System.out.println(application.applicationName + " wartosc: " + application.price);
        }
    }
}
