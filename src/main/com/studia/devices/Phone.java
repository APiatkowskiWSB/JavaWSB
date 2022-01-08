package main.com.studia.devices;

import main.com.studia.creatures.Human;

import java.net.URL;
import java.util.List;

public class Phone extends Device implements Saleable {
    final Double screenSize;
    String os;
    public final static String DEFAULT_SERVER_ADDRESS = "85.128.128.104";
    public final static String DEFAULT_PROTOCOL = "HTTP";
    public final static String DEFAULT_VERSION = "10.2.13";
    public final static String DEFAULT_APPLICATION = "INTELLIJ";

    public Phone(String producer, String model, Double screenSize, Integer yearOfProduction) {
        super(yearOfProduction, producer, model);
        this.screenSize = screenSize;
    }

    @Override
    public void turnOn() {
        System.out.println("Klikam guzik wlaczajacy telefon");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if(this.equals(seller.phone)) {
            System.out.println("Sprzedajacy posiada ten telefon do sprzedania");
            if(buyer.cash >= price) {
                System.out.println("Kupujacy ma wystarczajaco gotówki");
                buyer.cash -= price;
                seller.cash += price;
                seller.phone = null;
                System.out.println(seller.firstName + " sprzedal telefon " + this.producer + " " + this.model + " za cene " + price);
                buyer.phone = this;
                System.out.println(buyer.firstName + " kupil telefon " + this.producer + " " + this.model + " za cene " + price);
                System.out.println("Transakcja zakonczona");
            }else{
                System.out.println("Kupujacy nie ma wystarczaco gotówki, transakcja niemożliwa");
            }
        }else {
            System.out.println("Sprzedajacy nie posiada tego telefonu");
        }
    }

    @Override
    public void sale() {

    }

    @Override
    public void getPrice() {

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
        installAnApp(nazwaAplikacji,wersjaAplikacji,DEFAULT_SERVER_ADDRESS);
    }

    public void installAnApp(String nazwaAplikacji, String wersjaAplikacji, String adresServera) {
        System.out.println("zainstalowano na telefonie aplikacje " + nazwaAplikacji + " w wersji " +wersjaAplikacji +
                " na serverze " + adresServera);
    }

    public void installAnApp(List<String> applicationsToInstall) {
        for (String application: applicationsToInstall) {
            installAnApp(application);
        }
    }
    public void installAnApp(URL url) {
        System.out.println("twoj url to: " + url);
        System.out.println("Zainstalowana aplikacja to " + DEFAULT_APPLICATION + " w wersji " + DEFAULT_VERSION);
    }
}
