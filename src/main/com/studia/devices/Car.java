package main.com.studia.devices;

import main.com.studia.creatures.Human;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;


public abstract class Car extends Device implements Saleable {
    Double weight;
    Integer doors;
    public Double value;
    String typeOfEngine;
    public List<CarTransaction> transactions;
    private Human authorisedSeller;

    public Car(String model, String producer, Integer yearOfProduction, Human firstOwner, Double firstSaleValue) {
        super(yearOfProduction, producer, model);
        this.authorisedSeller = new Human("Sprzedawca z salonu");
        this.transactions = new LinkedList<>();
        value = firstSaleValue;
        this.transactions.add(new CarTransaction(firstOwner, authorisedSeller, firstSaleValue));
        firstOwner.addCarToGarage(this);
    }

    public Double getValue() {
        return value;
    }

    public int hashCode() {
        double result = 31 * 7 * model.hashCode() *
                producer.hashCode() *
                yearOfPRoduction *
                typeOfEngine.hashCode() *
                value;
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
                this.transactions.add(new CarTransaction(buyer, seller, price));
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
        return transactions.get(transactions.size() -1).getBuyer().equals(seller);
    }

    public boolean wasAnOwner(Human human) {
        return this.transactions.stream()
                .map(transaction -> transaction.getBuyer())
                .filter(carOwner -> carOwner.equals(human))
                .count() > 0;
    }

    public void doesASoldCarToB(Human a, Human b) {
        if(!wasAnOwner(a) || !wasAnOwner(b)) {
            System.out.println("Nie bylo transakcji pomiedzy sprzedajacym " + a.firstName + " a kupujacym " + b.firstName);
        } else {
            long numberOfTransactionBeetwenThem =  this.transactions.stream()
                    .filter(transaction -> transaction.getSeller().equals(a) && transaction.getBuyer().equals(b))
                    .count();
            if(numberOfTransactionBeetwenThem > 0) {
                System.out.println("Tak sprzedajacy " + a.firstName + " sprzedal samochod dla " + b.firstName);
            } else {
                System.out.println("Nie bylo transakcji pomiedzy sprzedajacym " + a.firstName + " a kupujacym " + b.firstName);
            }
        }
    }

    public int getNumberOfTransactionForCar(Car car) {
        return this.transactions.size();
    }
}
