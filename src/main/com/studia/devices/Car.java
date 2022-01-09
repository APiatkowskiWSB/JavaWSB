package main.com.studia.devices;

import main.com.studia.creatures.Human;

import java.util.LinkedList;
import java.util.List;


public abstract class Car extends Device implements Saleable {
    Double weight;
    Integer doors;
    public Double value;
    String typeOfEngine;
    public List<Human> owners;

    public Car(String model, String producer, Integer yearOfProduction, Human firstOwner) {
        super(yearOfProduction, producer, model);
        this.owners = new LinkedList<>();
        this.owners.add(firstOwner);
        firstOwner.addCarToGarage(this);
    }

    public Double getValue() {
        return value;
    }

    public int hashCode() {
        double result = 31 * 7 * model.hashCode() *
                producer.hashCode() *
                weight * doors * value;
        return (int) result;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o instanceof Car) {
            return false;
        }
        Car car = (Car) o;
        return model == car.model &&
                producer == car.producer &&
                weight == car.weight &&
                doors == car.doors &&
                car.value == car.value;
    }

    public abstract void refuel();

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", producer='" + producer + '\'' +
                ", weight=" + weight +
                ", doors=" + doors +
                ", value=" + value +
                '}';
    }

    public void turnOn() {
        System.out.println("Przekrecam kluczyk");
    }

    @Override
    public void sell(Human seller, Human buyer, Double price) {
        if (seller.hasCar(this)) {
            System.out.println("Sprzedajacy posiada ten samochod do sprzedania");
            if (!buyer.hasFreeParkingSlot()){
                System.out.println("kupujacy nie ma miejsca na parkingu zeby kupic auto");
            }
            else if(!this.isLastOwner(seller)){
                System.out.println("Sprzedajacy nie jest ostatnim wlascicielem auta");
            }
            else if (buyer.cash >= price) {
                System.out.println("Kupujacy ma wystarczajaco gotówki");
                buyer.cash -= price;
                seller.cash += price;
                seller.removeCar(this);
                System.out.println(seller.firstName + " sprzedal samochod " + this.producer + " " + this.model);
                buyer.addCarToGarage(this);
                owners.add(buyer);
                System.out.println(buyer.firstName + " kupil samochod " + this.producer + " " + this.model);
                System.out.println("Transakcja zakonczona");
            } else {
                System.out.println("Kupujacy nie ma wystarczaco gotówki, transakcja niemożliwa");
            }
        } else {
            System.out.println("Sprzedajacy nie posiada tego samochodu");
        }
    }

    private boolean isLastOwner(Human seller) {
        return owners.get(owners.size() -1).equals(seller);
    }

    public boolean wasAnOwner(Human human) {
        return this.owners.contains(human);
    }

    public boolean doesASoldToB(Human a, Human b) {
        if(!wasAnOwner(a) || !wasAnOwner(b)) {
            return false;
        } else {
            return this.owners.indexOf(b) - this.owners.indexOf(a) == 1;
        }
    }
}
