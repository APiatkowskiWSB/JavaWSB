package main.com.studia.devices;

import main.com.studia.creatures.Human;

public class Phone extends Device implements Saleable {
    final Double screenSize;
    String os;

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
}
